package org.mapledpmlab.type.skill.attackskill.zero;

public class WindCutter extends AssistSkill implements AlphaSkill {
    public WindCutter() {
        this.setName("윈드 커터");
        this.setAttackCount(8L);
        this.setDamage(265.0 + 30);
        //this.setDelayByAttackSpeed(720L);
        this.setDelay(420L);
        this.setRelatedSkill(new WindCutterTornado());
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setAssistDelay(540L);
    }
}
