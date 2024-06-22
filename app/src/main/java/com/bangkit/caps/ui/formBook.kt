package com.bangkit.caps.ui

import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.caps.R

class formBook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_book)

        val bookTitleEditText = findViewById<EditText>(R.id.book_title)
        val bookAuthorEditText = findViewById<EditText>(R.id.book_author)
        val bookPublisherEditText = findViewById<EditText>(R.id.book_publisher)
        val bookYearEditText = findViewById<EditText>(R.id.book_year)
        val bookDescriptionEditText = findViewById<EditText>(R.id.book_description)
        val bookCoverImageView = findViewById<ImageView>(R.id.book_cover)
        val addBookButton = findViewById<Button>(R.id.add_book_button)

        addBookButton.setOnClickListener {
            addBookButton.setOnClickListener {
                // Get the text from the EditText fields
                val bookTitle = bookTitleEditText.text.toString()
                val bookAuthor = bookAuthorEditText.text.toString()
                val bookPublisher = bookPublisherEditText.text.toString()
                val bookYear = bookYearEditText.text.toString()
                val bookDescription = bookDescriptionEditText.text.toString()

                // Get the selected image from the ImageView
                val bookCoverImageView = findViewById<ImageView>(R.id.book_cover)
                val bookCoverBitmap = (bookCoverImageView.drawable as BitmapDrawable).bitmap

                // Create a new Book object
//                val book = Book(
//                    title = bookTitle,
//                    author = bookAuthor,
//                    publisher = bookPublisher,
//                    year = bookYear.toInt(),
//                    description = bookDescription,
//                    coverImage = bookCoverBitmap
//                )

                // Add the book to the database
//                val db = DatabaseHelper(this)
//                db.addBook(book)

                // Show a toast message to confirm the book was added
                Toast.makeText(this, "Book added successfully!", Toast.LENGTH_SHORT).show()

                // Clear the EditText fields
                bookTitleEditText.text.clear()
                bookAuthorEditText.text.clear()
                bookPublisherEditText.text.clear()
                bookYearEditText.text.clear()
                bookDescriptionEditText.text.clear()
                bookCoverImageView.setImageBitmap(null)
            }
        }

        bookCoverImageView.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK && data!= null) {
            val selectedImageUri = data.data
            val bookCoverImageView = findViewById<ImageView>(R.id.book_cover)
            bookCoverImageView.setImageURI(selectedImageUri)
        }
    }
}