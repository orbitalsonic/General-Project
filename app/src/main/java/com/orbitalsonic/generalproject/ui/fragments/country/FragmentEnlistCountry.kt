package com.orbitalsonic.generalproject.ui.fragments.country

import android.graphics.*
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.FragmentEnlistCountryBinding
import com.orbitalsonic.generalproject.helpers.adapters.recyclerView.AdapterCountry
import com.orbitalsonic.generalproject.helpers.interfaces.OnCountryItemClickListener
import com.orbitalsonic.generalproject.helpers.listeners.DebounceListener.setDebounceClickListener
import com.orbitalsonic.generalproject.roomdb.tables.CountryTable
import com.orbitalsonic.generalproject.ui.fragments.base.BaseFragment

class FragmentEnlistCountry : BaseFragment<FragmentEnlistCountryBinding>(R.layout.fragment_enlist_country) {

    private lateinit var adapterCountry: AdapterCountry
    private lateinit var countryTableList: List<CountryTable>

    override fun onViewCreatedOneTime() {
        initRecyclerView()

        binding.fabAddEnlistCountry.setDebounceClickListener { navigateTo(R.id.fragmentEnlistCountry, R.id.action_fragmentEnlistCountry_to_fragmentCountry) }
    }

    override fun onViewCreatedEverytime() {
        initToolbarMenu()
        initObservers()
    }

    private fun initRecyclerView() {
        adapterCountry = AdapterCountry(object : OnCountryItemClickListener {
            override fun onCountryClick(countryTable: CountryTable) {
                val action = FragmentEnlistCountryDirections.actionFragmentEnlistCountryToFragmentCountryDetail(countryTable)
                navigateTo(R.id.fragmentEnlistCountry, action)
            }
        })
        binding.rvRoomListEnlistCountry.adapter = adapterCountry


        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onChildDraw(
                c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder,
                dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean
            ) {
                val paint = Paint()
                val icon: Bitmap
                if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
                    val itemView: View = viewHolder.itemView
                    val height = itemView.bottom.toFloat() - itemView.top.toFloat()
                    val width = height / 3
                    if (dX > 0) {
                        paint.color = Color.parseColor("#D32F2F")
                        val background = RectF(
                            itemView.left.toFloat(),
                            itemView.top.toFloat(),
                            dX,
                            itemView.bottom.toFloat()
                        )
                        c.drawRect(background, paint)
                        icon = BitmapFactory.decodeResource(resources, R.drawable.img_delete)
                        val iconDest = RectF(
                            itemView.left.toFloat() + width,
                            itemView.top.toFloat() + width,
                            itemView.left.toFloat() + 2 * width,
                            itemView.bottom.toFloat() - width
                        )
                        c.drawBitmap(icon, null, iconDest, paint)
                    } else {
                        paint.color = Color.parseColor("#388E3C")
                        val background = RectF(
                            itemView.right.toFloat() + dX,
                            itemView.top.toFloat(),
                            itemView.right.toFloat(),
                            itemView.bottom.toFloat()
                        )
                        c.drawRect(background, paint)
                        icon = BitmapFactory.decodeResource(resources, R.drawable.img_delete)
                        val iconDest = RectF(
                            itemView.right.toFloat() - 2 * width,
                            itemView.top.toFloat() + width,
                            itemView.right.toFloat() - width,
                            itemView.bottom.toFloat() - width
                        )
                        c.drawBitmap(icon, null, iconDest, paint)
                    }
                }
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                if (direction == ItemTouchHelper.LEFT || direction == ItemTouchHelper.RIGHT) {
                    diComponent.generalProjectViewModel.deleteCountry(adapterCountry.currentList[viewHolder.adapterPosition])
                }
            }
        }).attachToRecyclerView(binding.rvRoomListEnlistCountry)
    }

    private fun initToolbarMenu() {
        val menuHost = globalActivity as MenuHost
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_delete, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.menu_item_delete -> diComponent.generalProjectViewModel.deleteAllCountry()
                }
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun initObservers() {
        diComponent.generalProjectViewModel.allCountryList.observe(viewLifecycleOwner) {
            countryTableList = it
            adapterCountry.submitList(it)
            if (it.isEmpty()) {
                binding.mtvEmptyListEnlistCountry.visibility = View.VISIBLE
            } else {
                binding.mtvEmptyListEnlistCountry.visibility = View.GONE
            }
        }
    }

    override fun registerBackPressDispatcher() {
        onBackPressed {
            popFrom(R.id.fragmentEnlistCountry)
        }
    }
}