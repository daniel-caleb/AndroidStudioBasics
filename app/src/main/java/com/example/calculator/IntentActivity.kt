package com.example.calculator

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

import android.content.pm.PackageManager

import androidx.core.content.ContextCompat





class IntentActivity : AppCompatActivity() {
    lateinit var Buttonsms:Button
    lateinit var Buttoncall:Button
    lateinit var Buttoncamera:Button
    lateinit var Buttonemail:Button
    lateinit var Buttondial:Button
    lateinit var Buttonstk:Button
    lateinit var Buttonshare:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        Buttonsms=findViewById(R.id.btn_sms)
        Buttoncall=findViewById(R.id.btn_call)
        Buttoncamera=findViewById(R.id.btn_camera)
        Buttonemail=findViewById(R.id.btn_email)
        Buttondial=findViewById(R.id.btn_dial)
        Buttonstk=findViewById(R.id.btn_stk)
        Buttonshare=findViewById(R.id.btn_share)

        Buttonsms.setOnClickListener {
            val uri: Uri = Uri.parse("smsto:+254758963243")

            val intent = Intent(Intent.ACTION_SENDTO, uri)

            intent.putExtra("sms_body", "The SMS text")

            startActivity(intent)

        }

        Buttoncamera.setOnClickListener {

            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            startActivityForResult(takePictureIntent, 1)

        }

        Buttonemail.setOnClickListener {

            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "meshewacaleb254@gmail.com", null))

            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")

            emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")

            startActivity(Intent.createChooser(emailIntent, "Send email..."))

        }

        Buttondial.setOnClickListener {
            val phone = "+254758963243"

            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))

            startActivity(intent)

        }
        Buttonstk.setOnClickListener {
            val simToolKitLaunchIntent =
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")

            simToolKitLaunchIntent?.let { startActivity(it) }

        }

        Buttonshare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)

            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            shareIntent.type = "text/plain"

            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")

            startActivity(shareIntent)


    }
}