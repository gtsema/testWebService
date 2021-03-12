<div class="card" style="width: 18rem; height: 25rem;">
    <div class="card-body">
        <form>
            <div class="form-group">
                <input type="text" class="form-control form-control-sm" id="setStatusInputId" aria-describedby="userIdHelp" placeholder="Enter user id">
            </div>

            <br>

            <div class="form-check">
              <input class="form-check-input" type="radio" name="radio" id="radioOnline" checked>
              <label class="form-check-label" for="radioOnline">
                Online
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input" type="radio" name="radio" id="radioAway">
              <label class="form-check-label" for="radioAway">
                Away
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input" type="radio" name="radio" id="radioOffline">
              <label class="form-check-label" for="radioOffline">
                Offline
              </label>
            </div>

            <br>

            <button id="setStatusButton" type="button" class="btn btn-primary">Set status</button>
        </form>
    </div>
</div>
