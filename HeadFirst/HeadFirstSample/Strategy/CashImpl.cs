using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;

namespace HeadFirstSample.Strategy
{
    /// <summary>
    /// 正常收费策略
    /// </summary>
    internal class CashNomral : CashStrategy
    {
        public override double AcceptCash(double money)
        {
            return money;
        }
    }

    /// <summary>
    /// 打折策略
    /// </summary>
    internal class CashRebate : CashStrategy
    {
        private readonly double _robate = 1d; // 打多少折。

        /// <summary>
        /// 初始化打折策略
        /// </summary>
        /// <param name="robate">打多少折</param>
        public CashRebate(double robate)
        {
            _robate = robate;
        }

        public override double AcceptCash(double money)
        {
            return money * _robate;
        }
    }

    /// <summary>
    /// 返利策略
    /// </summary>
    internal class CashReturn : CashStrategy
    {
        private int _maxMoney = 300; //满多少才送
        private int _returnMoney = 100; // 送多少

        /// <summary>
        /// 初始化返利策略
        /// </summary>
        /// <param name="maxMoney">满多少</param>
        /// <param name="returnMoney">送多少</param>
        public CashReturn(int maxMoney, int returnMoney)
        {
            _maxMoney = maxMoney;
            _returnMoney = returnMoney;
        }

        public override double AcceptCash(double money)
        {
            double result = money;
            if (money >= _maxMoney) //满了
            {
                result = money - Math.Floor(money - _maxMoney) * _returnMoney;
            }
            return result;
        }
    }

}
