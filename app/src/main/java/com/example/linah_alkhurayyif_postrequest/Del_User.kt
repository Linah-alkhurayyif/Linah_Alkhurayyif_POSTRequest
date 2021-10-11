package com.example.linah_alkhurayyif_postrequest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_del_user.*
import kotlinx.android.synthetic.main.activity_del_user.view.*
import kotlinx.android.synthetic.main.users.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Del_User : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_del_user)
        gobaclk.setOnClickListener {
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
        var userId = intent.extras?.getInt("User_Id")!!
        deletedUser.text = "The user ${userId} successfully deleted !!"
        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
        apiInterface?.deleteUser(userId)?.enqueue(object:
            Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                Toast.makeText(applicationContext, "Delete Success!", Toast.LENGTH_SHORT).show()

            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(applicationContext, ""+t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
}