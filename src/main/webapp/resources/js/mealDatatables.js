var ajaxUrl = "ajax/profile/meals/";
var datatableApi;
var addTitle="meal.add";
var editTitle="meal.edit";

function updateTable() {
    $.ajax({
        type: "POST",
        url: ajaxUrl + "filter",
        data: $("#filter").serialize(),
        success: updateTableByData
    });
}

function clearFilter() {
    $("#filter")[0].reset();
    $.get(ajaxUrl, updateTableByData);
}


$(function () {
    datatableApi = $("#datatable").DataTable({
        "ajax": {
            "url": ajaxUrl,
            "dataSrc": ""
        },
        "paging": false,
        "info": true,
        "columns": [
            {
                "data": "dateTime",
                "render": function (data, type, row) {
                    if (type === "display") {
                        return data.replace("T"," ");
                    }
                    return data;
                }
            },
            {
                "data": "description"
            },
            {
                "data": "calories"
            },
            {
                "orderable": false,
                "defaultContent": "",
                "render": renderEditBtn
            },
            {
                "orderable": false,
                "defaultContent": "",
                "render": renderDeleteBtn
            }
        ],
        "order": [
            [
                0,
                "desc"
            ]
        ],
        "createdRow": function (row, data, dataIndex) {
            if (data.exceed) {
                $(row).addClass("exceeded");
            }
            else {
                $(row).addClass("normal");
            }
        },
        "initComplete": makeEditable
    });


    $('#startDate').datetimepicker(
        {
            timepicker:false,
            formatDate:'Y-m-d',
            lang:'ru'
        }
    );
    $('#endDate').datetimepicker(
        {
            timepicker:false,
            formatDate:'Y-m-d',
            lang:'ru'
        }
    );
    $('#startTime').datetimepicker(
        {
            datepicker:false,
            format:'H:i',
            lang:'ru'
        }
    );
    $('#endTime').datetimepicker(
        {
            datepicker:false,
            format:'H:i',
            lang:'ru'
        }
    );
    $('#dateTime').datetimepicker(
        {
            format:'Y-m-d\\TH:i:s',
            lang:'ru'
        }
    );

});