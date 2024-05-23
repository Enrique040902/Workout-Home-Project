//package com.example.proyectofis
//
//import android.content.Intent
//import android.os.Bundle
//import android.view.View
//import androidx.appcompat.app.AppCompatActivity
//import com.example.proyectofis.databinding.ActivityPrincipalBinding
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.firestore.FirebaseFirestore
//import com.google.firebase.firestore.SetOptions
//
//class PrincipalActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityPrincipalBinding
//    private var datos = Datos()
//    private var mAuth: FirebaseAuth? = null
//    private var bd: FirebaseFirestore? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityPrincipalBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        bd = FirebaseFirestore.getInstance()
//        mAuth = FirebaseAuth.getInstance()
//        val id = mAuth!!.currentUser!!.uid
//
//
//
//        // Acciones para los botones de nivel principiante
//        binding.btnPechoPrincipiante.setOnClickListener(View.OnClickListener { // Contar y almacenar los ejercicios hechos.
//            datos.ejercicios_realizados += 1
//            val dataEjercicios: MutableMap<String, Any> = HashMap()
//            dataEjercicios["ejercicios hechos"] = datos.ejercicios_realizados.toString()
//            bd!!.collection("users").document(id)[dataEjercicios] = SetOptions.merge()
//            bd!!.collection("users")
//                .document(id)
//                .get()
//                .addOnSuccessListener { documentSnapshot ->
//                    val ejercicios = documentSnapshot.getString("ejercicios hechos")
//                    //                            ejercicios_hechos.setText(ejercicios)
//                    binding.ejerciciosHechos.text = ejercicios
//                }
//
//            // Contar y almacenar las calorias quemadas
//            val calorias = 27f
//            datos.calorias_perdida += calorias
//            val dataCalorias: MutableMap<String, Any> = HashMap()
//            dataCalorias["calorias quemadas"] = datos.calorias_perdida.toString()
//            bd!!.collection("users").document(id)[dataCalorias] = SetOptions.merge()
//            bd!!.collection("users").document(id)
//                .get()
//                .addOnSuccessListener { documentSnapshot ->
//                    val caloriasPerdidas = documentSnapshot.getString("calorias quemadas")
////                            calorias_quemadas.setText(caloriasPerdidas)
//                    binding.caloriasQuemadas.text = caloriasPerdidas
//                }
//            val i = Intent(this@PrincipalActivity, PechoPrincipianteActivity::class.java)
//            startActivity(i)
//        })
//        binding.btnAbdominalesPrincipiante.setOnClickListener(View.OnClickListener { // Contar y almacenar los ejercicios hechos.
//            datos.ejercicios_realizados += 1
//            val dataEjercicios: MutableMap<String, Any> = HashMap()
//            dataEjercicios["ejercicios hechos"] = datos.ejercicios_realizados.toString()
//            bd!!.collection("users").document(id)[dataEjercicios] = SetOptions.merge()
//            bd!!.collection("users").document(id)
//                .get().addOnSuccessListener { documentSnapshot ->
//                    val ejercicios = documentSnapshot.getString("ejercicios hechos")
////                            ejercicios_hechos.setText(ejercicios)
//                    binding.ejerciciosHechos.text = ejercicios
//                }
//
//            // Contar y almacenar las calorias quemadas
//            val calorias = 64f
//            datos.calorias_perdida += calorias
//            val dataCalorias: MutableMap<String, Any> = HashMap()
//            dataCalorias["calorias quemadas"] = datos.calorias_perdida.toString()
//            bd!!.collection("users").document(id)[dataCalorias] = SetOptions.merge()
//            bd!!.collection("users").document(id)
//                .get().addOnSuccessListener { documentSnapshot ->
//                    val caloriasPerdidas = documentSnapshot.getString("calorias quemadas")
////                    calorias_quemadas.setText(caloriasPerdidas)
//                    binding.caloriasQuemadas.text = caloriasPerdidas
//                }
//            startActivity(
//                Intent(
//                    this@PrincipalActivity,
//                    AbdominalesPrincipianteActivity::class.java
//                )
//            )
//        })
//        binding.btnBrazoPrincipiante.setOnClickListener(View.OnClickListener { // Cuentar y almacenar los ejercicios hechos.
//            datos.ejercicios_realizados += 1
//            val dataEjercicios: MutableMap<String, Any> = HashMap()
//            dataEjercicios["ejercicios hechos"] = datos.ejercicios_realizados.toString()
//            bd!!.collection("users").document(id)[dataEjercicios] = SetOptions.merge()
//            bd!!.collection("users").document(id)
//                .get().addOnSuccessListener { documentSnapshot ->
//                    val ejercicios = documentSnapshot.getString("ejercicios hechos")
////                    ejercicios_hechos.setText(ejercicios)
//                    binding.ejerciciosHechos.text = ejercicios
//                }
//
//            // Contar y almacenar las calorias quemadas
//            val calorias = 7f
//            datos.calorias_perdida += calorias
//            val dataCalorias: MutableMap<String, Any> = HashMap()
//            dataCalorias["calorias quemadas"] = datos.calorias_perdida.toString()
//            bd!!.collection("users").document(id)[dataCalorias] = SetOptions.merge()
//            bd!!.collection("users").document(id)
//                .get().addOnSuccessListener { documentSnapshot ->
//                    val caloriasPerdidas = documentSnapshot.getString("calorias quemadas")
////                    calorias_quemadas.setText(caloriasPerdidas)
//                    binding.ejerciciosHechos.text = caloriasPerdidas
//                }
//            startActivity(Intent(this@PrincipalActivity, BrazoPrincipianteActivity::class.java))
//        })
//        binding.btnPiernaPrincipiante.setOnClickListener(View.OnClickListener { // Cuentar y almacenar los ejercicios hechos.
//            datos.ejercicios_realizados += 1
//            val data: MutableMap<String, Any> = HashMap()
//            data["ejercicios hechos"] = datos.ejercicios_realizados.toString()
//            bd!!.collection("users").document(id)[data] = SetOptions.merge()
//            bd!!.collection("users").document(id)
//                .get().addOnSuccessListener { documentSnapshot ->
//                    val ejercicios = documentSnapshot.getString("ejercicios hechos")
////                            ejercicios_hechos.setText(ejercicios)
//                    binding.ejerciciosHechos.text = ejercicios
//                }
//
//            // Contar y almacenar las calorias quemadas
//            val calorias = 20f
//            datos.calorias_perdida += calorias
//            val data2: Map<String, Any> = HashMap()
//            data["calorias quemadas"] = datos.calorias_perdida.toString()
//            bd!!.collection("users").document(id)[data] = SetOptions.merge()
//            bd!!.collection("users").document(id)
//                .get().addOnSuccessListener { documentSnapshot ->
//                    val caloriasPerdidas = documentSnapshot.getString("calorias quemadas")
////                    calorias_quemadas.setText(caloriasPerdidas)
//                    binding.caloriasQuemadas.text = caloriasPerdidas
//                }
//            startActivity(Intent(this@PrincipalActivity, PiernaPrincipianteActivity::class.java))
//        })
//
//        // Acciones para los botones de nivel medio.
//        binding.btnPechoMedio.setOnClickListener(View.OnClickListener { // Cuentar y almacenar los ejercicios hechos.
//            datos.ejercicios_realizados = datos.ejercicios_realizados + 1
//            val data: MutableMap<String, Any> = HashMap()
//            data["ejercicios hechos"] = datos.ejercicios_realizados.toString()
//            bd!!.collection("users").document(id)[data] = SetOptions.merge()
//            bd!!.collection("users").document(id)
//                .get().addOnSuccessListener { documentSnapshot ->
//                    val ejercicios = documentSnapshot.getString("ejercicios hechos")
////                            ejercicios_hechos.setText(ejercicios)
//                    binding.ejerciciosHechos.text = ejercicios
//                }
//
//            // Contar y almacenar las calorias quemadas
//            val calorias = 11f
//            datos.calorias_perdida += calorias
//            val data2: Map<String, Any> = HashMap()
//            data["calorias quemadas"] = datos.calorias_perdida.toString()
//            bd!!.collection("users").document(id)[data] = SetOptions.merge()
//            bd!!.collection("users").document(id)
//                .get().addOnSuccessListener { documentSnapshot ->
//                    val caloriasPerdidas = documentSnapshot.getString("calorias quemadas")
////                    calorias_quemadas.setText(caloriasPerdidas)
//                    binding.caloriasQuemadas.text = caloriasPerdidas
//                }
//            startActivity(Intent(this@PrincipalActivity, PechoMedioActivity::class.java))
//        })
//        binding.btnAbdominalesMedio.setOnClickListener(View.OnClickListener { // Cuentar y almacenar los ejercicios hechos.
//            datos.ejercicios_realizados += 1
//            val data: MutableMap<String, Any> = HashMap()
//            data["ejercicios hechos"] = datos.ejercicios_realizados.toString()
//            bd!!.collection("users").document(id)[data] = SetOptions.merge()
//            bd!!.collection("users").document(id)
//                .get().addOnSuccessListener { documentSnapshot ->
//                    val ejercicios = documentSnapshot.getString("ejercicios hechos")
////                    ejercicios_hechos.setText(ejercicios)
//                    binding.ejerciciosHechos.text = ejercicios
//                }
//
//            // Contar y almacenar las calorias quemadas
//            val calorias = 5f
//            datos.calorias_perdida += calorias
//            val data2: Map<String, Any> = HashMap()
//            data["calorias quemadas"] = datos.calorias_perdida.toString()
//            bd!!.collection("users").document(id)[data] = SetOptions.merge()
//            bd!!.collection("users").document(id)
//                .get().addOnSuccessListener { documentSnapshot ->
//                    val caloriasPerdidas = documentSnapshot.getString("calorias quemadas")
////                            calorias_quemadas.setText(caloriasPerdidas)
//                    binding.caloriasQuemadas.text = caloriasPerdidas
//                }
//            startActivity(Intent(this@PrincipalActivity, AbdominalesMedioActivity::class.java))
//        })
//        binding.btnBrazoMedio.setOnClickListener(View.OnClickListener { // Cuentar y almacenar los ejercicios hechos.
//            datos.ejercicios_realizados += 1
//            val data: MutableMap<String, Any> = HashMap()
//            data["ejercicios hechos"] = datos.ejercicios_realizados.toString()
//            bd!!.collection("users").document(id)[data] = SetOptions.merge()
//            bd!!.collection("users").document(id)
//                .get().addOnSuccessListener { documentSnapshot ->
//                    val ejercicios = documentSnapshot.getString("ejercicios hechos")
////                    ejercicios_hechos.setText(ejercicios)
//                    binding.ejerciciosHechos.text = ejercicios
//                }
//
//            // Contar y almacenar las calorias quemadas
//            val calorias = 5f
//            datos.calorias_perdida += calorias
//            val data2: Map<String, Any> = HashMap()
//            data["calorias quemadas"] = datos.calorias_perdida.toString()
//            bd!!.collection("users").document(id)[data] = SetOptions.merge()
//            bd!!.collection("users").document(id)
//                .get().addOnSuccessListener { documentSnapshot ->
//                    val caloriasPerdidas = documentSnapshot.getString("calorias quemadas")
////                            calorias_quemadas.setText(caloriasPerdidas)
//                    binding.caloriasQuemadas.text = caloriasPerdidas
//                }
//            startActivity(Intent(this@PrincipalActivity, BrazoMedioActivity::class.java))
//        })
//        binding.btnPiernaMedio.setOnClickListener(View.OnClickListener { // Cuentar y almacenar los ejercicios hechos.
//            datos.ejercicios_realizados += 1
//            val data: MutableMap<String, Any> = HashMap()
//            data["ejercicios hechos"] = datos.ejercicios_realizados.toString()
//            bd!!.collection("users").document(id)[data] = SetOptions.merge()
//            bd!!.collection("users").document(id)
//                .get().addOnSuccessListener { documentSnapshot ->
//                    val ejercicios = documentSnapshot.getString("ejercicios hechos")
////                    ejercicios_hechos.setText(ejercicios)
//                    binding.ejerciciosHechos.text = ejercicios
//                }
//
//            // Contar y almacenar las calorias quemadas
//            val calorias = 5f
//            datos.calorias_perdida += calorias
//            val data2: Map<String, Any> = HashMap()
//            data["calorias quemadas"] = datos.calorias_perdida.toString()
//            bd!!.collection("users").document(id)[data] = SetOptions.merge()
//            bd!!.collection("users").document(id)
//                .get().addOnSuccessListener { documentSnapshot ->
//                    val caloriasPerdidas = documentSnapshot.getString("calorias quemadas")
////                            calorias_quemadas.setText(caloriasPerdidas)
//                    binding.caloriasQuemadas.text = caloriasPerdidas
//                }
//            startActivity(Intent(this@PrincipalActivity, PiernaMedioActivity::class.java))
//        })
//
//        // Acciones para lo botones de nivel avanzado
//        binding.btnPechoAvanzado.setOnClickListener(View.OnClickListener { // Cuentar y almacenar los ejercicios hechos.
//            datos.ejercicios_realizados += 1
//            val data: MutableMap<String, Any> = HashMap()
//            data["ejercicios hechos"] = datos.ejercicios_realizados.toString()
//            bd!!.collection("users").document(id)[data] = SetOptions.merge()
//            bd!!.collection("users").document(id)
//                .get().addOnSuccessListener { documentSnapshot ->
//                    val ejercicios = documentSnapshot.getString("ejercicios hechos")
////                    ejercicios_hechos.setText(ejercicios)
//                    binding.ejerciciosHechos.text = ejercicios
//                }
//
//            // Contar y almacenar las calorias quemadas
//            val calorias = 5f
//            datos.calorias_perdida += calorias
//            val data2: Map<String, Any> = HashMap()
//            data["calorias quemadas"] = datos.calorias_perdida.toString()
//            bd!!.collection("users").document(id)[data] = SetOptions.merge()
//            bd!!.collection("users").document(id)
//                .get().addOnSuccessListener { documentSnapshot ->
//                    val caloriasPerdidas = documentSnapshot.getString("calorias quemadas")
////                            calorias_quemadas.setText(caloriasPerdidas)
//                    binding.caloriasQuemadas.text = caloriasPerdidas
//                }
//            startActivity(Intent(this@PrincipalActivity, PechoAvanzadoActivity::class.java))
//        })
//        binding.btnAbdominalesAvanzado.setOnClickListener { // Cuentar y almacenar los ejercicios hechos.
//            datos.ejercicios_realizados += 1
//            val data: MutableMap<String, Any> = HashMap()
//            data["ejercicios hechos"] = datos.ejercicios_realizados.toString()
//            bd!!.collection("users").document(id)[data] = SetOptions.merge()
//            bd!!.collection("users").document(id)
//                .get().addOnSuccessListener { documentSnapshot ->
//                    val ejercicios = documentSnapshot.getString("ejercicios hechos")
////                    ejercicios_hechos.setText(ejercicios)
//                    binding.ejerciciosHechos.text = ejercicios
//                }
//
//            // Contar y almacenar las calorias quemadas
//            val calorias = 5f
//            datos.calorias_perdida += calorias
//            val data2: Map<String, Any> = HashMap()
//            data["calorias quemadas"] = datos.calorias_perdida.toString()
//            bd!!.collection("users").document(id)[data] = SetOptions.merge()
//            bd!!.collection("users").document(id)
//                .get().addOnSuccessListener { documentSnapshot ->
//                    val caloriasPerdidas = documentSnapshot.getString("calorias quemadas")
////                            calorias_quemadas.setText(caloriasPerdidas)
//                    binding.caloriasQuemadas.text = caloriasPerdidas
//                }
//            startActivity(Intent(this@PrincipalActivity, AbdominalesAvanzadoActivity::class.java))
//        }
//        binding.btnBrazoAvanzado.setOnClickListener(View.OnClickListener { // Cuentar y almacenar los ejercicios hechos.
//            datos.ejercicios_realizados += 1
//            val data: MutableMap<String, Any> = HashMap()
//            data["ejercicios hechos"] = datos.ejercicios_realizados.toString()
//            bd!!.collection("users").document(id)[data] = SetOptions.merge()
//            bd!!.collection("users").document(id)
//                .get().addOnSuccessListener { documentSnapshot ->
//                    val ejercicios = documentSnapshot.getString("ejercicios hechos")
////                    ejercicios_hechos.setText(ejercicios)
//                    binding.ejerciciosHechos.text = ejercicios
//                }
//
//            // Contar y almacenar las calorias quemadas
//            val calorias = 5f
//            datos.calorias_perdida += calorias
//            val data2: Map<String, Any> = HashMap()
//            data["calorias quemadas"] = datos.calorias_perdida.toString()
//            bd!!.collection("users").document(id)[data] = SetOptions.merge()
//            bd!!.collection("users").document(id)
//                .get().addOnSuccessListener { documentSnapshot ->
//                    val caloriasPerdidas = documentSnapshot.getString("calorias quemadas")
////                            calorias_quemadas.setText(caloriasPerdidas)
//                    binding.caloriasQuemadas.text = caloriasPerdidas
//                }
//            startActivity(Intent(this@PrincipalActivity, BrazoAvanzadoActivity::class.java))
//        })
//
//        binding.btnPiernasAvanzado.setOnClickListener(View.OnClickListener { // Cuentar y almacenar los ejercicios hechos.
//            datos.ejercicios_realizados += 1
//            val data: MutableMap<String, Any> = HashMap()
//            data["ejercicios hechos"] = datos.ejercicios_realizados.toString()
//            bd!!.collection("users").document(id)[data] = SetOptions.merge()
//            bd!!.collection("users").document(id)
//                .get().addOnSuccessListener { documentSnapshot ->
//                    val ejercicios = documentSnapshot.getString("ejercicios hechos")
////                    ejercicios_hechos.setText(ejercicios)
//                    binding.ejerciciosHechos.text = ejercicios
//                }
//
//            // Contar y almacenar las calorias quemadas
//            val calorias = 5f
//            datos.calorias_perdida += calorias
//            val data2: Map<String, Any> = HashMap()
//            data["calorias quemadas"] = datos.calorias_perdida.toString()
//            bd!!.collection("users").document(id)[data] = SetOptions.merge()
//            bd!!.collection("users").document(id)
//                .get().addOnSuccessListener { documentSnapshot ->
//                    val caloriasPerdidas = documentSnapshot.getString("calorias quemadas")
////                            calorias_quemadas.setText(caloriasPerdidas)
//                    binding.caloriasQuemadas.text = caloriasPerdidas
//                }
//            startActivity(Intent(this@PrincipalActivity, PiernaAvanzadoActivity::class.java))
//        })
//    }
//}