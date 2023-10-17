package com.example.lab6.second

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.lab6.R
import com.example.lab6.databinding.ActivitySecondTaskBinding
import com.example.lab6.first.FirstTaskActivity

class SecondTaskActivity : AppCompatActivity() {

    private lateinit var rvAdapter: ElementsAdapter

    private lateinit var viewModel: SecondTaskViewModel

    private val binding by lazy {
        ActivitySecondTaskBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        rvAdapter = ElementsAdapter()
        viewModel = ViewModelProvider(this)[SecondTaskViewModel::class.java]
        setupRv()
        observeViewModel()
        binding.fabAddTv.setOnClickListener {
            viewModel.addNewListItem()
        }
    }

    private fun setupRv() {
        binding.rvTvs.adapter = rvAdapter
        setupSwipeListener()
    }

    private fun setupSwipeListener() {
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = rvAdapter.currentList[viewHolder.adapterPosition]
                viewModel.deleteListItem(item.id)
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(binding.rvTvs)
    }

    private fun observeViewModel() {
        viewModel.listsLD.observe(this) {
            rvAdapter.submitList(it)
        }
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, SecondTaskActivity::class.java)
    }
}