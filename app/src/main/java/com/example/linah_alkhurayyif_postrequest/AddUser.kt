package com.example.linah_alkhurayyif_postrequest

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_user.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.addNewUser
import retrofit2.Response
import javax.security.auth.callback.Callback

class AddUser : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)
        viewbtn.setOnClickListener {
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

        savebtn.setOnClickListener {
            if(editTextName.text.toString()==""||editTextLocation.text.toString()==""){
                Toast.makeText(applicationContext, "Can not submit empty data!!", Toast.LENGTH_SHORT).show()
            }else{
            val progressDialog = ProgressDialog(this@AddUser)
            progressDialog.setMessage("Please wait")
            progressDialog.show()
            var Newuser = UserDetails.User(editTextName.text.toString(), editTextLocation.text.toString(),null)
            val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
            apiInterface!!.addUser(Newuser).enqueue(object : retrofit2.Callback<UserDetails.User>{
                override fun onResponse(
                    call: retrofit2.Call<UserDetails.User>,
                    response: Response<UserDetails.User>
                ) {
                    progressDialog.dismiss()
                    editTextName.setText("")
                    editTextLocation.setText("")
                    Toast.makeText(applicationContext, "Save Success!", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: retrofit2.Call<UserDetails.User>, t: Throwable) {
                    progressDialog.dismiss()
                    Toast.makeText(applicationContext, ""+t.message, Toast.LENGTH_SHORT).show()
                }
            })
        }}
    }}