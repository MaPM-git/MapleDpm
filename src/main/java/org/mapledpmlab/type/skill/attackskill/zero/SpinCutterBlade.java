package org.mapledpmlab.type.skill.attackskill.zero;

public class SpinCutterBlade extends AssistSkill implements AlphaSkill {
    public SpinCutterBlade() {
        this.setName("스핀 커터(검기)");
        this.setAttackCount(4L);
        this.setDamage(233.0);
        this.setDelayByAttackSpeed(90L);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        //this.getMultiAttackInfo().add(420L);
        this.setAssistDelay(90L);
    }
}
