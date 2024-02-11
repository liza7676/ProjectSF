package com.example.project

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieAnimationView
import com.example.project.databinding.StartActivityBinding

class StartActiviti : Fragment() {
    private lateinit var binding: StartActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = StartActivityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val lottieAnimationView: LottieAnimationView = binding.lottieAnim
        lottieAnimationView.playAnimation()

        binding.btn.setOnClickListener{
            (requireActivity() as MainActivity).startApp()
        }
    }
}
