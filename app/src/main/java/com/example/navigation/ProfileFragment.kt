package com.example.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigation.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var binding: FragmentProfileBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(
            inflater,
            container,
            false
        )
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding!!.buttonOpen.setOnClickListener {
            val mBundle = Bundle()
            mBundle.putString("param1", "AMBO")

            findNavController().navigate(
                R.id.action_profileFragment_to_detailProfileFragment,
                mBundle
            )
        }

        binding!!.buttonOpenSafe.setOnClickListener {
            val action = ProfileFragmentDirections
                .actionProfileFragmentToDetailProfileFragment(
                    dataSatu = "a@gmail.com"
                )
            findNavController().navigate(action)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}