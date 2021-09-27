import React, { useEffect } from 'react';
import HomeComponent from 'components/HomeComponent';
import { useSelector, useDispatch } from 'react-redux';
import { login } from 'modules/auth' 

export default function HomeContainer(){
  const { data, loading, error } = useSelector( state => state.authReducer.auth );
  const dispatch = useDispatch();
  
  useEffect(() => {
    dispatch(login({login_id: "tester", password: "12345"}));
  }, [dispatch])
  
  return (
    <HomeComponent 
      data={data}
      loading={loading}
      error={error} 
      />
  )
}