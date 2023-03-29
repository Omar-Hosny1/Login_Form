package com.example.constraint_layout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.constraint_layout.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private val credentials: Credentials = Credentials()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        var args = HomeFragmentArgs.fromBundle(requireArguments())
        binding.credentials = credentials
        credentials.userName = "Email : ${args.userName}"
        credentials.password = args.password
        return binding.root
    }
}