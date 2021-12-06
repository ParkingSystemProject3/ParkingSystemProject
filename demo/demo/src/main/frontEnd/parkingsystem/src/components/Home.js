import Entry from "./Entry";
import Exit from "./Exit";
function Home() {
  return (
    <div className="login-wrap">
      <div className="login-html">
        <input
          id="tab-1"
          type="radio"
          name="tab"
          className="sign-in"
          defaultChecked
        />
        <label htmlFor="tab-1" className="tab">
          {" "}
          New registration{" "}
        </label>
        <input id="tab-2" type="radio" name="tab" className="sign-up" />
        <label htmlFor="tab-2" className="tab">
          Log out
        </label>
        <div className="login-form">
          <Entry />
          <Exit />
        </div>
      </div>
    </div>
  );
}
export default Home;
