<div class="card" style="width: 18rem; height: 26rem;">
    <div class="card-header">
        Add user
    </div>
    <div class="card-body">
        <form>
            <div class="form-group">
                <label for="inputName">Username</label>
                <input type="text" class="form-control form-control-sm" id="inputName" aria-describedby="usernameHelp" placeholder="Enter username">
                <small id="usernameHelp" class="form-text text-muted">Your name has changed long ago.</small>
            </div>

            <br>

            <div class="form-group">
                <label for="inputEmail">Email address</label>
                <input type="email" class="form-control form-control-sm" id="inputEmail" aria-describedby="emailHelp" placeholder="Enter email">
                <small id="usernameHelp" class="form-text text-muted">Your eyes have lost their colour for ever.</small>
            </div>

            <br>

            <div class="form-group">
                <label for="inputPhoneNumber">Phone number</label>
                <input type="tel" name="phone" id="inputPhone" class="form-control form-control-sm bfh-phone" data-format="+7 (ddd) ddd-dddd" value="" pattern="(\+[\d\ \(\)\-]{16})" />
            </div>
        </form>
    </div>

    <div class="card-footer text-muted">
        <button type="button" class="btn btn-primary" id="addUserButton">Add user</button>
    </div>
</div>
