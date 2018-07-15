function pageLoad () {
    setDefaultDate();
    loadMessages();
}

function setDefaultDate () {
    document.getElementById('date').valueAsDate = new Date();
}

function loadMessages () {

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

function renderMessage (transaction) {

    const transactionDiv =
        $(`<div class="card">` +
            `<div class="card-body">` +
                `<h5 class="card-title transactionAmount">Amount: </h5>` +
                `<h6 class="card-subtitle transactionCategory">Category: </h6>` +
                `<p class="card-text transactionDateAndID"></p>` +
            `</div>` +
        `</div>`);

    transactionDiv.find('.transactionAmount').text('Amount: ' + transaction.amount);
    transactionDiv.find('.transactionCategory').text('Category: ' + transaction.category);
    transactionDiv.find('.transactionDateAndID').text('Date: ' + transaction.date + "<br/>TransactionID: " + transaction.id);

    return transactionDiv;

    // relook lesson 5 slide 12

}