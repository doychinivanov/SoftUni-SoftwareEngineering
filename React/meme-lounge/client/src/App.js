import { Route, Switch } from 'react-router';

import { UserProvider } from './context/UserContext';

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
          <Route path="/" exact component={Home} />
          <Route path="/login" component={Login} />
          <Route path="/register" component={Register} />
          <Route path="/create" component={Create} />
          <Route path="/edit/:memeId" component={Edit} />
          <Route path="/details/:memeId" component={Details} />
          <Route path="/profile" component={Profile} />
          <Route path="/all" component={Feed} />

        </Switch>
      </UserProvider>

      <Footer></Footer>
    </>
  );
}

export default App;
