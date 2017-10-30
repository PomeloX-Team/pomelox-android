package com.example.poonsak.pomelo_x

import android.app.Activity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import android.support.v4.app.ActivityCompat.startActivityForResult
import android.provider.MediaStore
import android.content.Intent
import android.support.v4.app.ActivityCompat
import android.graphics.Bitmap
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ImageView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: RecyclerView.Adapter<*>? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null
    val myDataset = arrayOf("Januarty", "Feb", "March")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_SHORT)
                    .setAction("Action", null).show()
            dispatchTakePictureIntent()
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
        mAdapter = MyAdapter(input)
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
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
//        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
//            val extras = data.extras
//            val imageBitmap = extras!!.get("data") as Bitmap
//            val mImageView = findViewById<ImageView>(R.id.imgv_photo)
//            mImageView.setImageBitmap(imageBitmap)
//        }
    }


    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        }
    }

    companion object {
        internal val REQUEST_IMAGE_CAPTURE = 1
    }

}

