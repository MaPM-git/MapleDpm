package org.mapledpmlab.type.skill.attackskill.zero;

public class SpinCutter extends AssistSkill implements AlphaSkill {
    public SpinCutter() {
        this.setName("스핀 커터");
        this.setAttackCount(10L);
        this.setDamage(435.0);
        //this.setDelayByAttackSpeed(840L);
        this.setDelay(180L);
        this.setRelatedSkill(new SpinCutterBlade());
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setAssistDelay(270L);
    }
}
