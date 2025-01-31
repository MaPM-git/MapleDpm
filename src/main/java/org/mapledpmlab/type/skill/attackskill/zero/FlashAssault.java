package org.mapledpmlab.type.skill.attackskill.zero;

public class FlashAssault extends AssistSkill implements AlphaSkill {
    public FlashAssault() {
        this.setName("플래시 어썰터");
        this.setAttackCount(8L);
        this.setDamage(267.0);
        //this.setDelayByAttackSpeed(630L);
        this.setDelay(270L);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setAssistDelay(480L);
        this.setMove(true);
    }
}
