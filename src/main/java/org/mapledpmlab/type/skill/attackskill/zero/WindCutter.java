package org.mapledpmlab.type.skill.attackskill.zero;

public class WindCutter extends AssistSkill implements AlphaSkill {
    public WindCutter() {
        this.setName("윈드 커터");
        this.setAttackCount(7L);
        this.setDamage(265.0 + 70);
        this.setDelay(240L);
        this.setAssistDelay(240L);
        this.setRelatedSkill(new WindCutterTornado());
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setGaugeCharge(-17.0);
    }
}
