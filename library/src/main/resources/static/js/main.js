$(document).ready(function() {
    $('.table .editButton').on('click',function(event){

        var href = $(this).attr('href');
        event.preventDefault();
        $.get(href, function(book, status){
            $('#id').val(book.id);
            $('#edit_title').val(book.tytul);
            $('#edit_author').val(book.autor);
            $('#edit_year').val(book.rok);
            $('#edit_state').val(book.status);
        })
        $('#editModal').modal();
    });


    $('.table .deleteButton').on('click',function(event){

        var href = $(this).attr('href');
        event.preventDefault();
        $('#deleteModal #deletedId').attr('href',href)
        $('#deleteModal').modal();
    });
});