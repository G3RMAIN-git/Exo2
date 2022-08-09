package com.technipixl.evand1.exo2

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.EditText
import java.util.regex.Pattern

class MainActivity : Activity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.buttonlogin).setOnClickListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onClick(v: View) {
        val loginEmail = (findViewById<View>(R.id.editTextEmail) as EditText).text.toString()
        val password = (findViewById<View>(R.id.editTextPassword) as EditText).text.toString()


        if (!isLoginValid(loginEmail)) {
            val builder =
                AlertDialog.Builder(this).setMessage("Login invalide").setPositiveButton("Ok", null)
            val alertDialog = builder.create()
            alertDialog.show()
            return
        }

        if (password.isEmpty()) {
            val builder2 =
                AlertDialog.Builder(this).setMessage("Password is empty !").setPositiveButton("Ok", null)
            val alertDialog2 = builder2.create()
            return alertDialog2.show()
        }
        val intentConnection = Intent(this, ConnectedActivity::class.java)
        startActivity(intentConnection)
    }
    val EMAIL_ADDRESS_PATTERN: Pattern = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )
    private fun checkEmail(email: String): Boolean {
        return EMAIL_ADDRESS_PATTERN.matcher(email).matches()
    }

    private fun isLoginValid(login: String): Boolean {
        /*val firstCharacter = login.substring(0, 1)
        val value = firstCharacter.toInt()
        val convertedValue = Integer.toString(value)
        if (firstCharacter.compareTo(convertedValue) != 0) {
            return false
        }
        return login.contains("@")*/
        return checkEmail(login)




    }
}