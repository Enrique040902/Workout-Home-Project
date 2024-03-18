package com.example.proyectofis

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.basgeekball.awesomevalidation.AwesomeValidation
import com.basgeekball.awesomevalidation.ValidationStyle
import com.example.proyectofis.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private var awesomeValidation: AwesomeValidation? = null
    private var firebaseAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.splashScreenTheme)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Se inicializan los edit text
//        binding.etEmail = findViewById(R.id.binding.etEmail)
//        binding.etPassword = findViewById(R.id.binding.etPassword)
//
//        Se inicializan los botones
//        btn_login = findViewById(R.id.btn_login)
//        btn_registrar = findViewById(R.id.btn_registrar)
        firebaseAuth = FirebaseAuth.getInstance()
        val autenticacion = FirebaseAuth.getInstance()
        val user = autenticacion.currentUser

        // valida si ya existe un usuario y no se cierre la sesión.
        if (user != null) {
            goToHome()
        }
        awesomeValidation = AwesomeValidation(ValidationStyle.BASIC)
        awesomeValidation!!.addValidation(
            this,
            R.id.et_email,
            Patterns.EMAIL_ADDRESS,
            R.string.invalid_mail
        )
        awesomeValidation!!.addValidation(
            this,
            R.id.et_Password,
            ".{6,}",
            R.string.invalid_password
        )
        binding.btnRegistrar.setOnClickListener(View.OnClickListener {
            val i = Intent(this@LoginActivity, RegistrarActivity::class.java)
            startActivity(i)
        })
        binding.btnLogin.setOnClickListener(View.OnClickListener {
            val mail = binding.etEmail.text.toString()
            val pass = binding.etPassword.text.toString()
            if (awesomeValidation!!.validate() && camposVacios(mail, pass)) {
                firebaseAuth!!.signInWithEmailAndPassword(mail, pass)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            goToHome()
                        } else {
                            val errorCode = (task.exception as FirebaseAuthException?)!!.errorCode
                            darToastError(errorCode)
                        }
                    }
            }
        })
    } // fin del onCreate

    private fun goToHome() {
        val i = Intent(this, PrincipalActivity::class.java)
        i.putExtra("mail", binding.etEmail.text.toString().trim { it <= ' ' })
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(i)
    }

    private fun camposVacios(mail: String, pass: String): Boolean {
        return if (mail.isEmpty() && pass.isEmpty()) {
            Toast.makeText(this, "Llene todos los campos, por favor", Toast.LENGTH_SHORT).show()
            false
        } else true
    }

    private fun darToastError(error: String) {
        when (error) {
            "ERROR_INVALID_CUSTOM_TOKEN" -> Toast.makeText(
                this@LoginActivity,
                "El formato del token es inrrecto. Por favor revise la documentación",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_CUSTOM_TOKEN_MISMATCH" -> Toast.makeText(
                this@LoginActivity,
                "El token personalizado corresponde a una audiencia diferente.",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_INVALID_CREDENTIAL" -> Toast.makeText(
                this@LoginActivity,
                "La credencial de autenticación proporcionada tiene un formato incorrecto o ha caducado",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_INVALID_EMAIL" -> {
                Toast.makeText(
                    this@LoginActivity,
                    "La dirección de correo electronio está mal formateada",
                    Toast.LENGTH_LONG
                ).show()
                binding.etEmail.error = "La dirección de correo está mal formateda"
                binding.etEmail.requestFocus()
            }

            "ERROR_WRONG_PASSWORD" -> {
                Toast.makeText(
                    this@LoginActivity,
                    "la constraseña no es valida o el usuario no tiene constraseña",
                    Toast.LENGTH_LONG
                ).show()
                binding.etPassword.error = "La contraseña es incorrecta."
                binding.etPassword.requestFocus()
                binding.etPassword.setText("")
            }

            "ERROR_USER_MISMATCH" -> Toast.makeText(
                this@LoginActivity,
                "Las credenciales proporcionadas no corresponden al usuario que inició sesión anteriormente..",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_REQUIRES_RECENT_LOGIN" -> Toast.makeText(
                this@LoginActivity,
                "Esta operación es sensible y requiere autenticación reciente. Inicie sesión nuevamente antes de volver a intentar esta solicitud.",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL" -> Toast.makeText(
                this@LoginActivity,
                "Ya existe una cuenta con la misma dirección de correo electrónico pero diferentes credenciales de inicio de sesión. Inicie sesión con un proveedor asociado a esta dirección de correo electrónico.",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_EMAIL_ALREADY_IN_USE" -> {
                Toast.makeText(
                    this@LoginActivity,
                    "La dirección de correo electrónico ya está siendo utilizada por otra cuenta..   ",
                    Toast.LENGTH_LONG
                ).show()
                binding.etEmail!!.error =
                    "La dirección de correo electrónico ya está siendo utilizada por otra cuenta."
                binding.etEmail!!.requestFocus()
            }

            "ERROR_CREDENTIAL_ALREADY_IN_USE" -> Toast.makeText(
                this@LoginActivity,
                "Esta credencial ya está asociada con una cuenta de usuario diferente.",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_USER_DISABLED" -> Toast.makeText(
                this@LoginActivity,
                "La cuenta de usuario ha sido inhabilitada por un administrador..",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_USER_TOKEN_EXPIRED" -> Toast.makeText(
                this@LoginActivity,
                "La credencial del usuario ya no es válida. El usuario debe iniciar sesión nuevamente.",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_USER_NOT_FOUND" -> Toast.makeText(
                this@LoginActivity,
                "No hay ningún registro de usuario que corresponda a este identificador. Es posible que se haya eliminado al usuario.",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_INVALID_USER_TOKEN" -> Toast.makeText(
                this@LoginActivity,
                "La credencial del usuario ya no es válida, el usuario debe iniciar sesión nuevamente.",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_OPERATION_NOT_ALLOWED" -> Toast.makeText(
                this@LoginActivity,
                "Esta operación no está permitida. Debes habilitar este servicio en la consola.",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_WEAK_PASSWORD" -> {
                Toast.makeText(
                    this@LoginActivity,
                    "La contraseña proporcionada no es válida..",
                    Toast.LENGTH_LONG
                ).show()
                binding.etPassword.error =
                    "La contraseña no es válida, debe tener al menos 6 caracteres"
                binding.etPassword.requestFocus()
            }
        }
    }
}
