package com.example.cheffmenu

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.cheffmenu.R
import java.text.NumberFormat
import java.util.Locale

data class MenuItemData(
    var name: String,
    var description: String,
    var course: String,
    var price: Double
)

object MenuRepository {
    val items = mutableListOf(
        MenuItemData("Chicken Wings", "Crispy spicy wings served with dipping sauce", "Starter", 85.00),
        MenuItemData("Beef Burger Home Made", "Juicy 100% pure beef patty with cheese", "Main Course", 120.00),
        MenuItemData("Greek Salad", "Fresh cucumber, tomato, olives and feta", "Starter", 65.00),
        MenuItemData("Chocolate Brownie", "Warm chocolate brownie served with cream", "Dessert", 65.00)
    )
}

class MainActivity : Activity() {

    private val items get() = MenuRepository.items
    private lateinit var itemContainer: LinearLayout
    private lateinit var searchInput: EditText

    private val courses = listOf("All", "Starter", "Main Course", "Dessert", "Drinks")
    private var selectedCourse = "All"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        itemContainer = findViewById(R.id.menuItemContainer)
        searchInput = findViewById(R.id.searchInput)

        setupFilters()

        searchInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                renderMenu()
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        findViewById<Button>(R.id.addMenuButton).setOnClickListener {
            showMenuItemDialog(null)
        }

        findViewById<TextView>(R.id.statsNav).setOnClickListener {
            startActivity(Intent(this, StatisticsActivity::class.java))
        }

        renderMenu()
    }

    private fun setupFilters() {
        val container = findViewById<LinearLayout>(R.id.courseFilterContainer)
        container.removeAllViews()

        courses.forEach { course ->
            val chip = TextView(this).apply {
                text = course
                textSize = 14f
                typeface = Typeface.DEFAULT_BOLD
                gravity = Gravity.CENTER
                setPadding(dp(17), dp(9), dp(17), dp(9))

                setTextColor(
                    if (course == selectedCourse) Color.WHITE
                    else Color.DKGRAY
                )

                background = rounded(
                    if (course == selectedCourse) BROWN else Color.WHITE,
                    if (course == selectedCourse) BROWN else BORDER,
                    24
                )

                setOnClickListener {
                    selectedCourse = course
                    setupFilters()
                    renderMenu()
                }
            }

            val params = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                dp(43)
            )
            params.marginEnd = dp(9)
            container.addView(chip, params)
        }
    }

    private fun renderMenu() {
        itemContainer.removeAllViews()

        val query = searchInput.text.toString()
            .trim()
            .lowercase(Locale.getDefault())

        val filtered = items.filter { item ->
            (selectedCourse == "All" || item.course == selectedCourse) &&
                    (item.name.lowercase().contains(query) ||
                            item.description.lowercase().contains(query))
        }

        if (filtered.isEmpty()) {
            itemContainer.addView(TextView(this).apply {
                text = "No menu items found."
                textSize = 16f
                gravity = Gravity.CENTER
                setTextColor(Color.GRAY)
                setPadding(0, dp(32), 0, dp(32))
            })
        }

        filtered.forEach { item ->
            itemContainer.addView(createMenuCard(item))
        }
    }

    private fun createMenuCard(item: MenuItemData): View {
        val outer = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(0, 0, 0, dp(13))
        }

        val card = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(15), dp(16), dp(15), dp(15))
            background = rounded(Color.WHITE, BORDER, 12)
        }

        val top = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
        }

        val tag = TextView(this).apply {
            text = item.course.uppercase()
            textSize = 12f
            typeface = Typeface.DEFAULT_BOLD
            setTextColor(BROWN)
            setPadding(dp(11), dp(6), dp(11), dp(6))
            background = rounded(
                Color.rgb(255, 250, 226),
                Color.rgb(239, 218, 120),
                22
            )
        }

        top.addView(tag, LinearLayout.LayoutParams(
            0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f
        ))

        top.addView(TextView(this).apply {
            text = money(item.price)
            textSize = 21f
            typeface = Typeface.DEFAULT_BOLD
            setTextColor(Color.BLACK)
        })

        card.addView(top)

        card.addView(TextView(this).apply {
            text = item.name
            textSize = 21f
            typeface = Typeface.DEFAULT_BOLD
            setTextColor(Color.BLACK)
            setPadding(0, dp(15), 0, dp(5))
        })

        card.addView(TextView(this).apply {
            text = item.description
            textSize = 16f
            setTextColor(Color.DKGRAY)
        })

        val divider = View(this).apply {
            setBackgroundColor(Color.LTGRAY)
        }

        card.addView(divider, LinearLayout.LayoutParams(
            -1, dp(1)
        ).apply {
            topMargin = dp(17)
            bottomMargin = dp(13)
        })

        val actions = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.END
        }

        actions.addView(
            actionText("[Edit]", Color.rgb(255, 250, 230), BROWN)
                .apply {
                    setOnClickListener { showMenuItemDialog(item) }
                }
        )

        actions.addView(View(this), LinearLayout.LayoutParams(dp(9), 1))

        actions.addView(
            actionText("[Delete]", Color.rgb(255, 239, 239), Color.RED)
                .apply {
                    setOnClickListener { showDeleteDialog(item) }
                }
        )

        card.addView(actions)
        outer.addView(card)

        return outer
    }

    private fun actionText(
        label: String,
        fill: Int,
        textColor: Int
    ): TextView {
        return TextView(this).apply {
            text = label
            textSize = 14f
            typeface = Typeface.DEFAULT_BOLD
            gravity = Gravity.CENTER
            setTextColor(textColor)
            setPadding(dp(13), dp(10), dp(13), dp(10))
            background = rounded(fill, textColor, 11)
        }
    }

    private fun showMenuItemDialog(existing: MenuItemData?) {
        val content = layoutInflater.inflate(
            R.layout.dialog_menu_item, null
        )

        val name = content.findViewById<EditText>(R.id.dishNameInput)
        val description = content.findViewById<EditText>(R.id.dishDescriptionInput)
        val course = content.findViewById<Spinner>(R.id.courseSpinner)
        val price = content.findViewById<EditText>(R.id.priceInput)

        val options = listOf("Starter", "Main Course", "Dessert", "Drinks")

        course.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            options
        )

        if (existing != null) {
            name.setText(existing.name)
            description.setText(existing.description)
            price.setText(existing.price.toString())
            course.setSelection(options.indexOf(existing.course).coerceAtLeast(0))
        }

        val dialog = AlertDialog.Builder(this)
            .setView(content)
            .setPositiveButton(
                if (existing == null) "Add Item" else "Update Item",
                null
            )
            .setNegativeButton("Cancel", null)
            .create()

        dialog.setOnShowListener {
            dialog.getButton(AlertDialog.BUTTON_POSITIVE)
                .setOnClickListener {

                    val dishName = name.text.toString().trim()
                    val dishDescription = description.text.toString().trim()
                    val dishPrice = price.text.toString().toDoubleOrNull()

                    if (dishName.isBlank()) {
                        name.error = "Enter a dish name"
                        return@setOnClickListener
                    }

                    if (dishDescription.isBlank()) {
                        description.error = "Enter a description"
                        return@setOnClickListener
                    }

                    if (dishPrice == null || dishPrice < 0) {
                        price.error = "Enter a valid price"
                        return@setOnClickListener
                    }

                    if (existing == null) {
                        items.add(
                            MenuItemData(
                                dishName,
                                dishDescription,
                                course.selectedItem.toString(),
                                dishPrice
                            )
                        )
                    } else {
                        existing.name = dishName
                        existing.description = dishDescription
                        existing.course = course.selectedItem.toString()
                        existing.price = dishPrice
                    }

                    renderMenu()
                    dialog.dismiss()
                }
        }

        dialog.show()
    }

    private fun showDeleteDialog(item: MenuItemData) {
        val content = layoutInflater.inflate(
            R.layout.dialog_delete_item, null
        )

        content.findViewById<TextView>(R.id.deleteItemName).text =
            item.name

        content.findViewById<TextView>(R.id.deleteItemCoursePrice).text =
            "${item.course}  ·  ${money(item.price)}"

        val dialog = AlertDialog.Builder(this)
            .setView(content)
            .create()

        content.findViewById<Button>(R.id.confirmDeleteButton)
            .setOnClickListener {
                items.remove(item)
                dialog.dismiss()
                renderMenu()

                Toast.makeText(
                    this,
                    "Menu item deleted",
                    Toast.LENGTH_SHORT
                ).show()
            }

        content.findViewById<Button>(R.id.cancelDeleteButton)
            .setOnClickListener {
                dialog.dismiss()
            }

        dialog.show()
        dialog.window?.setBackgroundDrawableResource(
            android.R.color.transparent
        )
    }

    private fun money(value: Double): String {
        val formatter = NumberFormat.getNumberInstance(Locale("en", "ZA"))
        formatter.minimumFractionDigits = 2
        formatter.maximumFractionDigits = 2
        return "R" + formatter.format(value)
    }

    private fun rounded(
        fill: Int,
        stroke: Int,
        radius: Int
    ) = GradientDrawable().apply {
        setColor(fill)
        setStroke(dp(1), stroke)
        cornerRadius = dp(radius).toFloat()
    }

    private fun dp(value: Int): Int =
        (value * resources.displayMetrics.density).toInt()

    companion object {
        private const val BROWN = 0xFF7E310C.toInt()
        private const val BORDER = 0xFFDDDDDD.toInt()
    }
}
