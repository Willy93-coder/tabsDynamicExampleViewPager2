package com.example.tabsdynamicexampleviewpager2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tabsdynamicexampleviewpager2.databinding.FragmentPageBinding

class PageFragment : Fragment() {

    private lateinit var binding: FragmentPageBinding
    private var name: String? = null
    private var text: String? = null

    companion object {
        @JvmStatic
        fun newInstance(name: String, text: String) = PageFragment().apply {
            arguments = Bundle().apply {
                putString("name", name)
                putString("text", text)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString("name")
            text = it.getString("text")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPageBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.textView.text = name
        binding.textView2.text = text
    }
}