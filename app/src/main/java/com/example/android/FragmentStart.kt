package com.example.android


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_start.*
import android.content.Intent
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.example.android.kai.KAIActivity
import com.example.android.number.MainNumber
import com.example.android.stone.MainStone


class FragmentStart : Fragment() {

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        btnkai.setOnClickListener {
            startActivity(Intent(context, KAIActivity::class.java))
            Animatoo.animateShrink(context)
        }

        btnNumber.setOnClickListener {
            startActivity(Intent(context, MainNumber::class.java))
            Animatoo.animateShrink(context)
        }

        btnPone.setOnClickListener {
            startActivity(Intent(context, MainStone::class.java))
            Animatoo.animateShrink(context)
        }

        btnNumber2.setOnClickListener {
            startActivity(Intent(context, MainOOXX::class.java))
            Animatoo.animateShrink(context)
        }

        btnNumber3.setOnClickListener {
            startActivity(Intent(context, Main2::class.java))
            Animatoo.animateShrink(context)
        }
    }

}
