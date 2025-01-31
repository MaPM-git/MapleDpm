package org.mapledpmlab.type.skill.attackskill.zero;

public class ShadowStrikeBlade extends AssistSkill {
    public ShadowStrikeBlade() {
        this.setName("쉐도우 스트라이크(검기)");
        this.setAttackCount(1L);
        this.setDamage(514.0);
        this.setDelayByAttackSpeed(90L);
        this.addFinalDamage(2.8);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        //this.getMultiAttackInfo().add(900L);
        this.setAssistDelay(90L);
    }
}
