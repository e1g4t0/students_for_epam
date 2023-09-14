<div class="modal fade" id="updModal" tabindex="-1" aria-labelledby="updModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Edit window</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form class="row g-3" action="update" method="post">
                <div class="modal-body">
                    <div class="col-auto">
                        <input name = "name" type="text" class="form-control mb-3" id="name" placeholder="Name" style="text-align: center;">
                        <input name = "surname" type="text" class="form-control mb-3" id="surname" placeholder="Surname" style="text-align: center;">
                        <input name = "group" type="text" class="form-control mb-3" id="group" placeholder="Group" style="text-align: center;">
                        <input name = "year" type="number" class="form-control mb-3" id="year" placeholder="Admitted Year" style="text-align: center;">

                        <input type="hidden" name = "id" id = "updId">
                    </div>
                    <div class="modal-footer" style="justify-content: center;">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">Submit</button>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>