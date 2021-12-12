package com.example.mvp_rxjava2_dagger_moxy

import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.example.mvp_rxjava2_dagger_moxy.databinding.ActivityMainBinding
import java.io.ByteArrayOutputStream
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    companion object {
        private val REQUEST_TAKE_PHOTO = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.convert?.setOnClickListener {
            choosePhoto()
        }
    }

    fun choosePhoto(){
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(
            Intent.createChooser(intent, "Select Picture"),
            REQUEST_TAKE_PHOTO
        )
    }

    fun saveBitmap(uri: Uri) {

        var imageStream: InputStream? = null
        try {
            imageStream = uri.let {
                contentResolver.openInputStream(
                    it
                )
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
        val bitmap: Bitmap = BitmapFactory.decodeStream(imageStream)
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
        try {
            stream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        val contentValues = ContentValues().apply {
            put(MediaStore.Images.Media.DISPLAY_NAME, "sami.png")
            put(MediaStore.Images.Media.MIME_TYPE, "pictures")
            put(MediaStore.Images.Media.WIDTH, bitmap.width)
            put(MediaStore.Images.Media.HEIGHT, bitmap.height)
        }

        try {
            contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
                .also { uris ->
                    uris?.let {
                        contentResolver.openOutputStream(it).use { outpustream ->
                            if (!bitmap.compress(Bitmap.CompressFormat.PNG, 95, outpustream)) {
                                throw IOException("error")
                            }
                        }
                    }
                }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        binding?.image?.setImageBitmap(bitmap)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == 1000) {
            val uri: Uri? = data?.data
            uri?.let { saveBitmap(it) }
        }
    }
}