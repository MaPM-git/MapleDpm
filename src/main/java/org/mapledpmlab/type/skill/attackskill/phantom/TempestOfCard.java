package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class TempestOfCard extends AttackSkill {
    public TempestOfCard() {
        this.setName("템페스트 오브 카드");
        this.setAttackCount(4L);
        this.setDamage(840.0);
        this.setDotDuration(2560L);
        this.setInterval(150L);
        this.setRelatedSkill(new TempestOfCardAfterDelay());
        this.setAddDamage(20L);             // 템페스트 오브 카드-리인포스
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
