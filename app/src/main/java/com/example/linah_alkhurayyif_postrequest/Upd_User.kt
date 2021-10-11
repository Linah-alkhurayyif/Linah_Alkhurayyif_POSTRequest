package com.example.linah_alkhurayyif_postrequest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_upd_user.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Upd_User : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upd_user)
        var userId = intent.extras?.getInt("User_Id")!!
        var User_Name =intent.extras?.getString("User_Name")!!
        var User_Location =intent.extras?.getString("User_Location")!!
        Uuser_id.text = "User ${userId}"
        UeditTextName.hint = User_Name
        UeditTextLocation.hint = User_Location
        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
        babkbtn.setOnClickListener {
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
        Usavebtn.setOnClickListener {
            var UserName =User_Name
            var UserLocation =User_Location
            if(UeditTextName.text.toString() != ""){
                UserName=UeditTextName.text.toString()
            }
            if(UeditTextLocation.text.toString() != ""){
                UserLocation= UeditTextLocation.text.toString()
            }
                    apiInterface?.updateUser(userId,UserDetails.User(UserName,UserLocation,userId))?.enqueue(object:
            Callback<UserDetails.User> {
                    override fun onResponse(
                        call: Call<UserDetails.User>,
                        response: Response<UserDetails.User>
                    ) {
                        Toast.makeText(applicationContext, "Update Success!", Toast.LENGTH_SHORT).show()
                        nextPage()
                    }

                    override fun onFailure(call: Call<UserDetails.User>, t: Throwable) {
                        Toast.makeText(applicationContext, ""+t.message, Toast.LENGTH_SHORT).show()
                    }
                })

        }
    }
    private fun nextPage(){

        intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }
}