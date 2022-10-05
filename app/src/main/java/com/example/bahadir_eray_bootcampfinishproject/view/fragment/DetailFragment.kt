package com.example.bahadir_eray_bootcampfinishproject.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.bahadir_eray_bootcampfinishproject.databinding.FragmentDetailBinding
import com.example.bahadir_eray_bootcampfinishproject.util.downloadFromUrl
import com.example.bahadir_eray_bootcampfinishproject.util.placeholderProgressBar
import com.example.bahadir_eray_bootcampfinishproject.viewmodel.DetailViewModel

class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        viewModel.getDataTopFrom()

        val args = this.arguments
        val inputTitle = args?.get("travelsTitle")
        val inputCity = args?.get("travelsCity")
        val inputImg = args?.get("travelsImg")
        val inputDescription = args?.get("travelsDescription")
        binding.detailCiytText.text = inputCity.toString()
        binding.detailTitleText.text = inputTitle.toString()
        binding.detailDescriptiontext.text = inputDescription.toString()
        binding.detailImgView.downloadFromUrl(
            inputImg.toString(),
            placeholderProgressBar(requireActivity())
        )
    }
}