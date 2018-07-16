function pageLoad () {

    setDefaultDate();
    loadMessages();
    resetForm();

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

// function renderMessage (transaction) {
//
//     const transactionDiv =
//         $(`<div class="card">` +
//             `<div class="card-body">` +
//                 `<h5 class="card-title transactionAmount">Amount: </h5>` +
//                 `<h6 class="card-subtitle transactionCategory">Category: </h6>` +
//                 `<p class="card-text transactionDateAndID"></p>` +
//             `</div>` +
//         `</div>`);
//
//     transactionDiv.find('.transactionAmount').text('Amount: ' + transaction.amount);
//     transactionDiv.find('.transactionCategory').text('Category: ' + transaction.category);
//     transactionDiv.find('.transactionDateAndID').text('Date: ' + transaction.date + "<br/>TransactionID: " + transaction.id);
//
//     return transactionDiv;
//
//     // relook lesson 5 slide 12
//
// }

function renderMessage (transaction) {

    return `<div class="card">` +
                `<div class="card-body">` +
                    `<h5 class="card-title">Amount: ${transaction.amount}</h5>` +
                    `<h6 class="card-subtitle">Category: ${transaction.category}</h6>` +
                    `<p class="card-text">Date: ${transaction.date}<br/>TransactionID: ${transaction.id}</p>` +
                `</div>` +
            `</div>`;

}

// <div class="card">
//     <div class="card-body">
//     <h5 class="card-title">Amount: </h5>
// <h6 class="card-subtitle mb-2 text-muted">Category: </h6>
// <p class="card-text">Date: <br />TransactionID: </p>
// </div>
// </div>

function resetForm () {

    const form = $('#transactionForm');

    form.submit(event => {

        event.preventDefault();

        $.ajax ({

            url: '/transaction/new',
            type: 'POST',
            data: form.serialize(),
            success: loadMessages()

        });

    });

}