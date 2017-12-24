package com.madlab.poonsak.pomelo_x

import android.annotation.SuppressLint
import android.app.Activity
import android.arch.persistence.room.Room
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import android.provider.MediaStore
import android.content.Intent
import android.os.AsyncTask
import android.os.Build
import android.os.Environment
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v4.content.FileProvider
import android.util.Log
import com.madlab.poonsak.pomelo_x.persistence.PomeloLog
import com.madlab.poonsak.pomelo_x.persistence.PomeloLogDb
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: RecyclerView.Adapter<*>? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null
    private var mCurrentPhotoPath: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pomelogDb = Room.databaseBuilder(this, PomeloLogDb::class.java, "PomeloLog").build()

        object : AsyncTask<Void, Void, PomeloLog>() {
            override fun doInBackground(vararg params: Void?): PomeloLog {
                val pomeloLog = PomeloLog()
                pomeloLog.setCapture_date(Date().toString())
//                pomeloLog.setRipe_date(Date().toString())
                pomeloLog.setPath("nice")
                pomelogDb.pomeloLogDao().insert(pomeloLog)
                return pomeloLog
            }

            override fun onPostExecute(pomeloLog: PomeloLog) {
                super.onPostExecute(pomeloLog)
            }
        }.execute()

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            dispatchTakePictureIntent()
//            Snackbar.make(view, "" + mCurrentPhotoPath, Snackbar.LENGTH_SHORT)
//                    .setAction("Action", null).show()
            Log.d("URI", "" + mCurrentPhotoPath)

        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        initInstances()
    }

    private fun initInstances() {
        mRecyclerView = findViewById<RecyclerView>(R.id.recv_main)
        mRecyclerView!!.setHasFixedSize(true)
        mLayoutManager = LinearLayoutManager(this)
        mRecyclerView!!.setLayoutManager(mLayoutManager)
        val input = ArrayList<String>()
        for (i in 0..2) {
            input.add("Test" + i)
        }// define an adapter
        mAdapter = RecyclerViewAdapter(input)
        mRecyclerView!!.setAdapter(mAdapter)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.nav_setting -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_gallery -> {

            }
            R.id.nav_setting -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send_feedback -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    //get thumbnail image
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
//            val extras = data.extras
//            val imageBitmap = extras!!.get("data") as Bitmap
//            val mImageView = findViewById<ImageView>(R.id.iv_test)
//            mImageView.setImageBitmap(imageBitmap)
        }
    }


    private fun dispatchTakePictureIntent() {
        val takePictureIntent: Intent?
        takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            var photoFile: File? = null
            try {
                photoFile = createImageFile()
            } catch (ex: IOException) {
            }

            if (photoFile != null) {
                val photoURI: android.net.Uri?

                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                    photoURI = android.net.Uri.fromFile(photoFile)
                } else {
                    photoURI = FileProvider.getUriForFile(this,
                            "com.madlab.poonsak.pomelo_x", photoFile)
                }

                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO)
            }
        }
    }

    @SuppressLint("SimpleDateFormat")
    @Throws(IOException::class)
    private fun createImageFile(): File {
        // Create an image file name
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageFileName = "JPEG_" + timeStamp + "_"
        val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val image = File.createTempFile(
                imageFileName, /* prefix */
                ".jpg", /* suffix */
                storageDir      /* directory */
        )

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath()
        return image
    }

    companion object {
        lateinit var pomelogDb: PomeloLogDb
        internal val REQUEST_IMAGE_CAPTURE = 1
        internal val REQUEST_TAKE_PHOTO = 1
    }

}

