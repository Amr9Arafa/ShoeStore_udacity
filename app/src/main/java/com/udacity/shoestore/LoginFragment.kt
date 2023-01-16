package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )

        binding.loginBtn.setOnClickListener { view ->
            Navigation.findNavController(view)
                .navigate(R.id.action_loginFragment_to_welcomeFragment)
        }

        binding.registerBtn.setOnClickListener { view ->
            Navigation.findNavController(view)
                .navigate(R.id.action_loginFragment_to_welcomeFragment)
        }
        return binding.root
    }

}