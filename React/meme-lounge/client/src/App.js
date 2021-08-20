import { Route, Switch } from 'react-router';

import { UserProvider } from './context/UserContext';

import IsGuest from './guards/IsGuest';
import isAuth from './guards/isAuth';

import Create from './components/Create/index';
import Edit from './components/Edit/index';
import Header from './components/Header/index';
import Home from './components/Home/index';
import Login from './components/Login/index';
import Register from './components/Register/index';
import Footer from './components/Footer/index';
import Profile from './components/Profile/index';
import Feed from './components/Feed/index'
import Details from './components/Details/Details';


function App() {
  return (
    <>
      <UserProvider>
        <Header></Header>

        <Switch>
          <Route path="/" exact component={IsGuest(Home)} />
          <Route path="/login" component={IsGuest(Login)} />
          <Route path="/register" component={IsGuest(Register)} />
          <Route path="/create" component={isAuth(Create)} />
          <Route path="/edit/:memeId" component={isAuth(Edit)} />
          <Route path="/details/:memeId" component={isAuth(Details)} />
          <Route path="/profile" component={isAuth(Profile)} />
          <Route path="/all" component={isAuth(Feed)} />

        </Switch>
      </UserProvider>

      <Footer></Footer>
    </>
  );
}

export default App;
