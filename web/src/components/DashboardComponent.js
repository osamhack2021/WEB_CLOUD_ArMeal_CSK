import React from 'react';
import styled from 'styled-components'
import DoughnutChart from './shared/DoughnutChart';

const Container = styled.div`
  
`

const Wrapper1 = styled.div`
@media (max-width: 500px){
  width: auto;
  display: block;

}
@media (min-width: 768px) and (max-width: 1100px){
  width: inherit;
  display: block;
}

  display: flex;
  justify-content: space-between;
  width: 70vw;
  padding: 0 4vw;
  margin-top: ${props => props.margin ? props.margin : 0};
`
const Wrapper2 = styled.div`
@media (max-width: 500px){
  width: auto;
  margin: 0px 0px;
}
@media (min-width: 768px) and (max-width: 1100px){
  width: inherit;
  display: block;
}
  display: flex;
  justify-content: space-between;
  width: 70vw;
  padding: 0 4vw;
  margin-top: ${props => props.margin ? props.margin : 0};
`

const Box1 = styled.div`
@media (max-width: 500px){
  width: auto;
  padding-bottom: 20px;
}
@media (min-width: 768px) and (max-width: 1100px){
  height: auto;
  width: inherit;
  padding: 20px;
}
  width: ${props => props.width ? props.width : 0};
  height: ${props => props.height ? props.height : "auto"};
  background-color: #FFFFFF;
  border: 1px solid #E9E9EF;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
`
const Box2 = styled.div`
@media (max-width: 500px){
  width: auto;
  margin-top: 10px;
  padding-bottom: 20px;
}
@media (min-width: 768px) and (max-width: 1023px){
  width: inherit;
  height: 43vh;
  margin: 10px 0px;
}
@media (min-width: 1024px) and (max-width: 1100px){
  width: inherit;
  height: 39vh;
  margin: 10px 0px;
}
  width: ${props => props.width ? props.width : 0};
  height: ${props => props.height ? props.height : "auto"};
  background-color: #FFFFFF;
  border: 1px solid #E9E9EF;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
`
const Box3 = styled.div`
@media (min-width: 768px) and (max-width: 1024px){
  width: -webkit-fill-available;
  height: 24vh;
}

@media (min-width: 1024px) and (max-width: 1100px){
  width: -webkit-fill-available;
  height: 17vh;
}
@media (max-width: 500px){
  width:100%;
  margin-top: 10px;
}
  width: ${props => props.width ? props.width : 0};
  height: ${props => props.height ? props.height : "auto"};
  background-color: #FFFFFF;
  border: 1px solid #E9E9EF;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
`

const Head = styled.div`
  font-style: normal;
  font-weight: bold;
  font-size: 22px;
  color: #000000;
  padding: 18px 0 0 18px;
`

const ChartWrapper = styled.div`
@media (max-width: 500px){
  justify-content: space-around;
}
@media (min-width: 768px) and (max-width: 1100px){
  width: -webkit-fill-available;
  justify-content: space-evenly;
}
  width: 100%;
  display: flex;
  justify-content: center;
`
const DoughnutchartWrapper = styled.div`
@media (max-width: 500px){
  width: 300px;
}
@media (min-width: 768px) and (max-width: 1100px){
  width: 350px;
}
width: 350px;
`
const Score = styled.div`
@media (max-width: 500px){
  width: auto;
  left: 40vw;
  top: 36vh;
}
@media (min-width: 1024px) and (max-width: 1100px){
  top: 30vh;
}
  position: absolute;
  font-size: 30px;
  top: 35vh;
  font-weight: 800;
  text-align: center;
  width: 350px;
`

const Point = styled.div`
  font-size: 40px;
  color: ${props => props.satisfy > 65 ? "#FF0000" : props.satisfy > 32 ? "#FF6534" : "#F1C114"};
`

const DataSpec = styled.div`
@media (max-width: 500px){
  display:none;
}
@media (min-width: 768px) and (max-width: 1100px){
  padding:0px;
  width: 26vw;
}
  width: 12vw;
  padding-top: 8vh;
  padding-left: 2vw;
`

const SatisfyData = styled.div`
@media (min-width: 768px) and (max-width: 1100px){
  margin: 35px 0px;
}
@media (min-width: 1024px) and (max-width: 1100px){
  font-size: 29px;
}
  font-size: 22px;
  margin-bottom: 20px;
`

const Badge = styled.div`
@media (min-width: 1024px) and (max-width: 1100px){
  height: 35px;
  font-size: 15px;
  font-size: 24px;
  width: 106px;
  line-height: 31px;
}
  width: 65px;
  height: 24px;
  border: 3px solid #36A2EB;
  box-sizing: border-box;
  border-radius: 20px;
  float: right;
  text-align: center;
  font-size: 15px;
  font-weight: 800;
`

const LeaderBoard = styled.div`
  margin-top: 22px;
  padding: 0 13px;
`

const MenuRank = styled.div`
  margin-bottom: 14px;
  font-size: 20px;
  height: 6vh;
  cursor: pointer;
`

const Rank = styled.span`
  font-weight: bold;
  font-size: 22px;
`

const Satisfy = styled.span`
  float: right;
  color: ${props => props.color > 65 ? "#FF0000" : props.color > 32 ? "#FF6534" : "#E7B70A"};
  font-weight: bold;
  font-size: 22px;
`

const PercentWrapper = styled.div`
  margin-top: 2px;
  width: 100%;
  background-color: #C4C4C4;
  border-radius: 8px;
  height: 16px;
`

const Percent = styled.div`
  float: left;
  height: 16px;
  border-radius: 8px;
  background-color: ${props => props.satisfy > 65 ? "#FF0000" : props.satisfy > 32 ? "#FF6534" : "#F1C114"};
  width: ${props => props.satisfy ? props.satisfy + "%" :"0"};
`

const TodayWrapper = styled.div`
  margin-top: 27px;
  padding: 0 23px;
  display: flex;
  justify-content: space-between;
`

const TypeBox = styled.div`
@media (max-width: 500px){
  height: 17vh;
}
@media (min-width: 768px) and (max-width: 1024px){
  height: 14vh;
}
@media (min-width: 1024px) and (max-width: 1100px){
  height: 10vh;
}
  width: 20vw;
  height: 17vh;
  background-color: #EAEAEA;
  padding: 0 13px;
`

const TypeName = styled.div`
  text-align: center;
  padding-top: 18px;
  font-weight: bold;
  font-size: 25px;
`

const TypeSatisfy = styled.div`
  text-align: center;
  padding-top: 15px;
  font-size: 22px;
  font-weight: bold;
  color: ${props => props.satisfy > 65 ? "#FF0000" : props.satisfy > 32 ? "#FF6534" : props.satisfy ? "#E7B70A" : "#85859A"};
`

const TypeBarWrapper = styled.div`
  margin-top: 10px;
  width: 100%;
  background-color: #C4C4C4;
  height: 18px;
`

const TypeBar = styled.div`
  float: left;
  height: 18px;
  background-color: ${props => props.satisfy > 65 ? "#FF0000" : props.satisfy > 32 ? "#FF6534" : "#F1C114"};
  width: ${props => props.satisfy ? props.satisfy + "%" :"0"};
`

export default function DashboardComponent({chartData, average, dataName, menuRanking, todayData, history}){
  return (
    <Container>
      <Wrapper1>
        <Box1 width="45vw" height="47vh">
          <Head>
            전체 만족도
          </Head>
          <ChartWrapper>
            <DoughnutchartWrapper>
              {/* <DoughnutChart chartData={chartData}/> */}
              <DoughnutChart chartData={chartData} width='350px'/>
              <Score>
                평균
                <Point satisfy={average}>
                  {average}%
                </Point>
              </Score>
            </DoughnutchartWrapper>
            <DataSpec>
              {chartData.map((data, index) => {
                return (
                  <SatisfyData key={index}>
                    {dataName[index]}
                    <Badge>
                      {data}
                    </Badge>
                  </SatisfyData>
                )
              })}
            </DataSpec>
          </ChartWrapper>
        </Box1>


        <Box2 width="20vw" height="47vh">
          <Head>
            메뉴 랭킹
          </Head>
          <LeaderBoard>
            {menuRanking.map((menuData) => {
              return (
                <MenuRank key={menuData.rank} onClick={() => history.push(`/menu/${menuData.id}`)}>
                  <Rank>
                    {menuData.rank}
                  </Rank>
                    ) {menuData.name}
                  <Satisfy color={menuData.satisfy}>
                    {Math.round(menuData.satisfy)}%  
                  </Satisfy>
                  <PercentWrapper>
                    <Percent satisfy={menuData.satisfy}></Percent>
                  </PercentWrapper>
                </MenuRank>
              )
            })}
          </LeaderBoard>
        </Box2>
      </Wrapper1>

      
      <Wrapper2 margin="28px">
        <Box3 width="70vw" height="28vh">
          <Head>
            금일 만족도
          </Head>
          <TodayWrapper>
            {todayData.map((data) => {
              return (
                <TypeBox key={data.type}>
                  <TypeName>
                    {data.type}
                  </TypeName>
                  <TypeSatisfy satisfy={data.satisfy}>
                    {data.satisfy ? data.satisfy + "%" : "아직 평가되지 않았어요."}
                  </TypeSatisfy>
                  
                  <TypeBarWrapper>
                    <TypeBar satisfy={data.satisfy}></TypeBar>
                  </TypeBarWrapper>
                </TypeBox>
              )
            })}
          </TodayWrapper>
        </Box3>
      </Wrapper2>
    </Container>
  )
}