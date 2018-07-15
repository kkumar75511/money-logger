function pageLoad () {
    setDefaultDate();
    loadMessages();
}

function setDefaultDate () {
    document.getElementById('date').valueAsDate = new Date();
}

function loadMessages () {

    let transactionsHTML = '';

    $.ajax ({

        url: '/transaction/list',
        type: 'GET',
        success: transactionList => {

            $('#transactions').empty();

            for (let transaction of transactionList) {

                $('#transactions').append(renderMessage(transaction));

            }

            // for (let transaction of transactionList) {
            //
            //     transactionsHTML += renderMessage(transaction);
            //
            // }
            //
            // $('#transactions').html(transactionsHTML);

        }

    });

}