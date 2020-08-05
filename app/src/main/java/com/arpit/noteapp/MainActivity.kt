package com.arpit.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arpit.noteapp.Adaptor.userAdaptor
import com.arpit.noteapp.Model.User
import com.arpit.noteapp.ViewModel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

   private lateinit var userViewModel: UserViewModel
    private lateinit var  builder: AlertDialog.Builder
    private lateinit var dialog:AlertDialog
    private lateinit var name:EditText
    private lateinit var age:EditText
    private lateinit var button:Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdaptor: userAdaptor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            recyclerView=findViewById(R.id.recyclerview)
          userAdaptor= userAdaptor(this,ArrayList<User>())

            recyclerView.apply {
            setHasFixedSize(true)
            layoutManager=LinearLayoutManager(this@MainActivity)
            adapter=userAdaptor
        }
        userViewModel=ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.getalldata(applicationContext)?.observe(this , Observer {
             userAdaptor.setdata(it as ArrayList<User>)
        })

      floatingbutton.setOnClickListener{
          openDialog()
      }

















    }

    private fun openDialog() {
     builder=AlertDialog.Builder(this)
        var itemView:View =LayoutInflater.from(applicationContext).inflate(R.layout.dialog , null)
        dialog=builder.create()
        dialog.setView(itemView)
        name=itemView.findViewById(R.id.namedialog)
        age=itemView.findViewById(R.id.agedialog)
        button=itemView.findViewById(R.id.buttondialog)

        button.setOnClickListener{
            saveData()
        }
        dialog.show()

    }

    private fun saveData() {
        val getName= name.text.toString().trim()
        val getage=age.text.toString().trim()

        if (!TextUtils.isEmpty(getName) && !TextUtils.isEmpty(getage)){
            userViewModel.insert(this , User(getName , Integer.parseInt(getage)))
            dialog.dismiss()
          }
          else{
            Toast.makeText(applicationContext , "Please fill your data" , Toast.LENGTH_SHORT).show()

        }



    }

}