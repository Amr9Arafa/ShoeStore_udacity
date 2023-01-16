package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListingBinding
import com.udacity.shoestore.databinding.ItemShoeCardBinding
import com.udacity.shoestore.models.Shoe


class ShoeListingFragment : Fragment() {


    private val viewModel: ShoesViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding: FragmentShoeListingBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_listing, container, false
        )

//        setHasOptionsMenu(true)

        val menuHost: MenuHost = requireActivity()


//        viewModel = ViewModelProvider(this).get(ShoesViewModel::class.java)

        viewModel.shoeList.observe(viewLifecycleOwner, Observer { shoeList ->
            updateShoeList(binding, shoeList)

        })





        binding.addShoeBtn.setOnClickListener { view ->
            Navigation.findNavController(view)
                .navigate(ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailFragment())
        }

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                // Add menu items here
                menuInflater.inflate(R.menu.menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                // Handle the menu selection


                return findNavController().navigateUp()
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)



        return binding.root
    }

    private fun updateShoeList(
        binding: FragmentShoeListingBinding,
        shoeList: MutableList<Shoe>
    ) {
        var bindingShoe: ItemShoeCardBinding
        shoeList.forEach { shoe: Shoe ->
            bindingShoe = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.item_shoe_card,
                binding.rootView,
                false
            )
            binding.rootView.addView(bindingShoe.shoeCardView)
            bindingShoe.shoeNameTv.setText(shoe.name)
            bindingShoe.shoeSizeTv.setText(shoe.size.toString())
            bindingShoe.shoeDescriptionTv.setText(shoe.description)
            bindingShoe.shoeCompanyNameTv.setText(shoe.company)
        }
    }


//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        super.onCreateOptionsMenu(menu, inflater)
//        inflater.inflate(R.menu.menu, menu)
//
//
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
//                || super.onOptionsItemSelected(item)
//    }


}