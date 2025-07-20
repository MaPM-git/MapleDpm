package org.mapledpmlab.type.skill.attackskill.blaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class VulcanPunchKeydown extends AttackSkill {
    public VulcanPunchKeydown() {
        this.setName("발칸 펀치(키다운)");
        this.setAttackCount(10L);
        this.setDamage(1650.0);
        this.setDelay(510L);
        this.setDotDuration(510L);
        this.setInterval(30L);
        this.setLimitAttackCount(17L);
        this.setRelatedSkill(new VulcanPunchAfterDelay());
        this.addFinalDamage(1.6);       // 코어 강화
        this.setApplyFinalAttack(true);
    }
}
