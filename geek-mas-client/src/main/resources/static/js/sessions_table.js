$(document).ready(function () {
    $('#dtBasicExample').DataTable();
    $('.dataTables_length').addClass('bs-select');

    //Edit row buttons
    // $('.dt-edit').each(function () {
    //     console.log("clicked")
        $('.dt-edit').on('click', function(evt){
            $this = $(this);
            var dtRow = $this.parents('tr');
            console.log(dtRow[0].cells[3].innerHTML)

            $('#studentID').val(dtRow[0].cells[0].innerHTML) ;
            $('#studentName').val(dtRow[0].cells[1].innerHTML) ;
            // $('#tmSessionType').text(dtRow[0].cells[2].innerHTML);
            $('#sessionDate').val(dtRow[0].cells[3].innerHTML);

            $('#myModal').modal('show');
        });
    // });

    //Delete buttons
    // $('.dt-delete').each(function () {
        $('.dt-delete').on('click', function(evt){
            $this = $(this);
            var dtRow = $this.parents('tr');
            if(confirm("Are you sure to delete this row?")){
                var table = $('#dtBasicExample').DataTable();
                table.row(dtRow[0].rowIndex-1).remove().draw( false );
                window.location="sessions"
            }
        });
    // });
    $('#myModal').on('hidden.bs.modal', function (evt) {
        $('.modal .modal-body').empty();
        window.location="sessions"
    });
});