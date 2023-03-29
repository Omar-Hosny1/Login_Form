package com.example.constraint_layout

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.constraint_layout.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private var credentials: Credentials = Credentials()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.credentials = credentials
        binding.loginButton.setOnClickListener { view: View ->
            save(view, context)
        }
        return binding.root
    }

    private fun save(view: View, context: Context?) {
        binding.apply {
            val userName = credentials!!.userName
            val password = credentials!!.password
            if (password.isNotEmpty() && userName.isNotEmpty()) {
                view.findNavController().navigate(LoginFragmentDirections.actionLoginFragment2ToHomeFragment2(userName,password))
            } else {
                Toast.makeText(context, "Enter a valid credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }
}