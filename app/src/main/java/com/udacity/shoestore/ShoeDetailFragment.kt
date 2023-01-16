package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding


/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetailFragment : Fragment() {


    private val viewModel: ShoesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail,
            container, false
        )


        binding.shoe = viewModel.shoe
        binding.lifecycleOwner = this

        binding.saveBtn.setOnClickListener { view ->
            viewModel.addNewShoe(viewModel.shoe)
            Navigation.findNavController(view)
                .navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListingFragment())
        }

        binding.cancelBtn.setOnClickListener { view ->
            Navigation.findNavController(view)
                .navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListingFragment())
        }
        return binding.root

    }


}