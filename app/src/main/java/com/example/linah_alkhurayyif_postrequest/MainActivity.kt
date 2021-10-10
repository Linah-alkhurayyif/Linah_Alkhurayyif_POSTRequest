package com.example.linah_alkhurayyif_postrequest

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val userInfo: ArrayList<UserInfo> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val progressDialog = ProgressDialog(this@MainActivity)
        progressDialog.setMessage("Please wait")
        progressDialog.show()
        addNewUser.setOnClickListener {
            intent = Intent(applicationContext, AddUser::class.java)
            startActivity(intent)
        }
        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
        val call: Call<List<UserDetails.User>>? = apiInterface!!.doGetListUser()
        call?.enqueue(object : Callback<List<UserDetails.User>>{
            override fun onResponse(
                call: Call<List<UserDetails.User>>,
                response: Response<List<UserDetails.User>>
            ) {
                progressDialog.dismiss()
                for (user in response.body()!!){
                    userInfo.add(UserInfo(user.name.toString(),user.location.toString()))
                    Log.d("TAG","${user.name.toString()} ${user.location.toString()}")
                }
                initializeRV()
            }

            override fun onFailure(call: Call<List<UserDetails.User>>, t: Throwable) {
                progressDialog.dismiss()
                Toast.makeText(applicationContext, ""+t.message, Toast.LENGTH_SHORT).show();
            }
        })


    }
    private fun initializeRV(){
        recyclerView.adapter = UserAdapter(userInfo)
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}