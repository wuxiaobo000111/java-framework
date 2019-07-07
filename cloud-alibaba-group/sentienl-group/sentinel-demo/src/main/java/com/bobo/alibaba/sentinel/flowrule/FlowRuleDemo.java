package com.bobo.alibaba.sentinel.flowrule;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

public class FlowRuleDemo {
    public static void main(String[] args) {
        List<FlowRule> list = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("wuxiaobo");
        //限流的模式是根据资源的QPS来定义的
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(20);
        list.add(rule);
        FlowRuleManager.loadRules(list);
        while (true) {
            Entry entry = null;
            try {
                entry = SphU.entry("wuxiaobo");
                System.out.println("hello world");
            } catch (BlockException e1) {
                System.out.println("block!");
            } finally {
                if (entry != null) {
                    entry.exit();
                }
            }
        }
    }
}
