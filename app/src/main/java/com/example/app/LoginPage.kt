package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.app.databinding.ActivityLoginPageBinding

class LoginPage : AppCompatActivity() {
    private lateinit var binding: ActivityLoginPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            btnLogin.setOnClickListener{
                val username = "kyokta"
                val password = "492596"

                val inp_username = this.username.text.toString()
                val inp_password = this.password.text.toString()

                if (inp_username == username && inp_password == password) {
                    val intent =Intent(this@LoginPage, HomePage::class.java)
                    startActivity(intent)
                    finish()
                } else if (inp_username == username) {
                    Toast.makeText(this@LoginPage,
                        "Password yang Anda masukkan salah!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@LoginPage,
                        "Akun Anda belum terdaftar!", Toast.LENGTH_SHORT).show()}
            }
        }
    }
}