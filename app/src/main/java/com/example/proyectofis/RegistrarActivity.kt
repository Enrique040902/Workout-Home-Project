package com.example.proyectofis

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.basgeekball.awesomevalidation.AwesomeValidation
import com.basgeekball.awesomevalidation.ValidationStyle
import com.example.proyectofis.components.WarningPopUpComponent
import com.example.proyectofis.databinding.ActivityRegistrarBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.firestore.FirebaseFirestore

class RegistrarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrarBinding

    // Se hace uso de la libreria AwesomeValidation.
    private var awesomeValidation: AwesomeValidation? = null

    // Autenticación de firebase
    private var autenticacion: FirebaseAuth? = null

    // Para almacenar los datos en la firebaseFirestore.
    private var firebaseFirestore: FirebaseFirestore? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarBinding.inflate(layoutInflater)
        setContentView(binding.root)



        // se obtiene la instacia de firebase authentication y de Firebase Firestore
        autenticacion = FirebaseAuth.getInstance()
        firebaseFirestore = FirebaseFirestore.getInstance()

        // se valida el mail y el password
        awesomeValidation = AwesomeValidation(ValidationStyle.BASIC)
        awesomeValidation!!.addValidation(
            this,
            R.id.et_Email,
            Patterns.EMAIL_ADDRESS,
            R.string.invalid_mail
        )
        awesomeValidation!!.addValidation(
            this,
            R.id.et_Password,
            ".{6,}",
            R.string.invalid_password
        )

        binding.btnRegistrar.setContent {
            var showPopUpWarning by rememberSaveable { mutableStateOf(false) }


            Button(onClick = {
                val mail = binding.etEmail.text.toString().trim{ it <= ' ' }
                val pass = binding.etPassword.text.toString().trim{ it <= ' ' }
                val peso = binding.etPeso.text.toString().trim{ it <= ' ' }
                val estatura = binding.etEstatura.text.toString().trim{ it <= ' ' }
                val edad = binding.etEdad.text.toString().trim{ it <= ' ' }
                if (awesomeValidation!!.validate() && camposVacios(
                        peso,
                        estatura,
                        edad
                    )
                ) {
                    if (edad.toInt() >= 60)
                        showPopUpWarning = true
                    else {
                        registrarUsuario(mail, pass, peso, estatura, edad)
                        goToPrincipal()

                    }
                }
            }
            ) {
                Text(text = stringResource(R.string.listo))
            }
            WarningPopUpComponent(
                showPopUp = showPopUpWarning,
                onDismiss = { showPopUpWarning = false },
                onConfirm = {
//                    showPopUpWarning = false
                    val mail = binding.etEmail.text.toString().trim{ it <= ' ' }
                    val pass = binding.etPassword.text.toString().trim{ it <= ' ' }
                    val peso = binding.etPeso.text.toString().trim{ it <= ' ' }
                    val estatura = binding.etEstatura.text.toString().trim{ it <= ' ' }
                    val edad = binding.etEdad.text.toString().trim{ it <= ' ' }
                    registrarUsuario(mail, pass, peso, estatura, edad)
                    goToPrincipal()

                })
        }

//        binding.btnRegistrar.setOnClickListener(View.OnClickListener {
//            // Variables para hacer uso del contenido de los edit text.
//            val mail = binding.etEmail.text.toString().trim { it <= ' ' }
//            val pass = binding.etPassword.text.toString().trim { it <= ' ' }
//            val peso = binding.etPeso.text.toString().trim { it <= ' ' }
//            val estatura = binding.etEstatura.text.toString().trim { it <= ' ' }
//            val edad = binding.etEdad.text.toString().trim { it <= ' '}
//            if (awesomeValidation!!.validate()) { // valida si son correctos los campos mail y pass
//                goToPrincipal()
//                registrarUsuario(mail, pass, peso, estatura, edad)
//            } else { // Si no son validos los campos
//                Toast.makeText(
//                    this@RegistrarActivity,
//                    "Complete todos los datos",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//        })
    } // fin del OnCreate

    private fun camposVacios(
        peso: String,
        estatura: String,
        edad: String
    ): Boolean {
        return if (peso.isEmpty() && estatura.isEmpty() && edad.isEmpty()) {
            Toast.makeText(this, "Llene todos los campos, por favor", Toast.LENGTH_SHORT).show()
            false
        } else true
    }

    private fun goToPrincipal() {
        startActivity(Intent(this@RegistrarActivity, LoginActivity::class.java))
    }

    private fun registrarUsuario(
        mail: String,
        pass: String,
        peso: String,
        estatura: String,
        edad: String
    ) {

        autenticacion!!.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener { task ->

            // Crea un usuario con email y password.
            if (task.isSuccessful) {
                val id = autenticacion!!.currentUser!!.uid
                val map: MutableMap<String, Any> = HashMap()
                map["Correo electronico"] = mail
                map["Contraseña"] = pass
                map["Peso"] = peso
                map["Estatura"] = estatura
                map["Edad"] = edad
                firebaseFirestore!!.collection("users").document(id).set(map)
                Toast.makeText(
                    this@RegistrarActivity,
                    "Usuario creado con exito",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            } else {
                val errorCode = (task.exception as FirebaseAuthException?)!!.errorCode
                giveMeErrorToast(errorCode)
            }
        }
    }

    @Composable
    fun WarningPopUpComponent(
        showPopUp: Boolean,
        onDismiss: () -> Unit,
        onConfirm: () -> Unit
    ) {
        if (showPopUp) {
            AlertDialog(
                onDismissRequest = { onDismiss() },
                confirmButton = {
                    TextButton(onClick = { onConfirm() }) {
                        Text(text = stringResource(R.string.aceptar))
                    }
                },
                dismissButton = {
                    TextButton(onClick = { onDismiss() }) {
                        Text(text = stringResource(R.string.no_aceptar))
                    }
                },
                title = {
                    Text(text = stringResource(R.string.advertencia))
                },
                text = {
                    Text(
                        text = """ La aplicación no se hace resposable de las posibles lesiones que pueda tener
                            ya que por su edad puede causar le daños fisicos que pueden traer seria consecuencias
                            ¿Aún así desea ingresar?""".trimMargin()
                    )
                }
            )
        }
    }

    private fun giveMeErrorToast(error: String) {
        when (error) {
            "ERROR_INVALID_CUSTOM_TOKEN" -> Toast.makeText(
                this@RegistrarActivity,
                "El formato del token es inrrecto. Por favor revise la documentación",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_CUSTOM_TOKEN_MISMATCH" -> Toast.makeText(
                this@RegistrarActivity,
                "El token personalizado corresponde a una audiencia diferente.",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_INVALID_CREDENTIAL" -> Toast.makeText(
                this@RegistrarActivity,
                "La credencial de autenticación proporcionada tiene un formato incorrecto o ha caducado",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_INVALID_EMAIL" -> {
                Toast.makeText(
                    this@RegistrarActivity,
                    "La dirección de correo electronio está mal formateada",
                    Toast.LENGTH_LONG
                ).show()
                binding.etEmail.error = "La dirección de correo está mal formateda"
                binding.etEmail.requestFocus()
            }

            "ERROR_WRONG_PASSWORD" -> {
                Toast.makeText(
                    this@RegistrarActivity,
                    "la constraseña no es valida o el usuario no tiene constraseña",
                    Toast.LENGTH_LONG
                ).show()
                binding.etPassword.error = "La contraseña es incorrecta."
                binding.etPassword.requestFocus()
                binding.etPassword.setText("")
            }

            "ERROR_USER_MISMATCH" -> Toast.makeText(
                this@RegistrarActivity,
                "Las credenciales proporcionadas no corresponden al usuario que inició sesión anteriormente..",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_REQUIRES_RECENT_LOGIN" -> Toast.makeText(
                this@RegistrarActivity,
                "Esta operación es sensible y requiere autenticación reciente. Inicie sesión nuevamente antes de volver a intentar esta solicitud.",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL" -> Toast.makeText(
                this@RegistrarActivity,
                "Ya existe una cuenta con la misma dirección de correo electrónico pero diferentes credenciales de inicio de sesión. Inicie sesión con un proveedor asociado a esta dirección de correo electrónico.",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_EMAIL_ALREADY_IN_USE" -> {
                Toast.makeText(
                    this@RegistrarActivity,
                    "La dirección de correo electrónico ya está siendo utilizada por otra cuenta..   ",
                    Toast.LENGTH_LONG
                ).show()
                binding.etEmail.error =
                    "La dirección de correo electrónico ya está siendo utilizada por otra cuenta."
                binding.etEmail.requestFocus()
            }

            "ERROR_CREDENTIAL_ALREADY_IN_USE" -> Toast.makeText(
                this@RegistrarActivity,
                "Esta credencial ya está asociada con una cuenta de usuario diferente.",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_USER_DISABLED" -> Toast.makeText(
                this@RegistrarActivity,
                "La cuenta de usuario ha sido inhabilitada por un administrador..",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_USER_TOKEN_EXPIRED" -> Toast.makeText(
                this@RegistrarActivity,
                "La credencial del usuario ya no es válida. El usuario debe iniciar sesión nuevamente.",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_USER_NOT_FOUND" -> Toast.makeText(
                this@RegistrarActivity,
                "No hay ningún registro de usuario que corresponda a este identificador. Es posible que se haya eliminado al usuario.",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_INVALID_USER_TOKEN" -> Toast.makeText(
                this@RegistrarActivity,
                "La credencial del usuario ya no es válida, el usuario debe iniciar sesión nuevamente.",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_OPERATION_NOT_ALLOWED" -> Toast.makeText(
                this@RegistrarActivity,
                "Esta operación no está permitida. Debes habilitar este servicio en la consola.",
                Toast.LENGTH_LONG
            ).show()

            "ERROR_WEAK_PASSWORD" -> {
                Toast.makeText(
                    this@RegistrarActivity,
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