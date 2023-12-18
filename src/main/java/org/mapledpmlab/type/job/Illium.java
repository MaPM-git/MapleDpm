package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.ReuseBossCritical;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.farm.ReuseFarm;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.FlowOfBattle;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.union.IntUnion;

import java.util.stream.Collectors;

public class Illium extends Job {

    public Illium() {
        // 기본
        super();
        this.setName("일리움");
        this.setConstant(1.2);          // 무기상수
        this.setMastery(1.90 / 2);      // 숙련도
        this.setJobType(JobType.ETC);

        // 무기
        this.addMainStat((long) (150 + 32 + 145));
        this.addSubStat((long) (150 + 145));
        this.addMagic((long) (400 + 246 + 72 + 202));
        this.setWeaponAttMagic((long) (400 + 246 + 72 + 202));
        this.addBossDamage((long) (30 + 10));
        this.addIgnoreDefenseList(20L);
        this.addBossDamage(70L);
        this.addMagicP(9L);
        this.addMagicP(21L);
        this.addMagicP(3L);

        // 보조
        this.addMainStat(10L);
        this.addSubStat(10L);
        this.addMagic(3L);
        this.addBossDamage(70L);
        this.addMagicP(9L);
        this.addMagicP(21L);
        
        // 1차
        this.addCriticalP(20.0);        // 매직 건틀렛 마스터리
        this.addDamage(10L);            // 블레스 마크

        // 2차
        this.addFinalDamage(1.01);      // 브레싱 앙상블
        this.addMainStat(20L);          // 매직 액셀레이션
        this.addMagic(10L);             // 스펠 마스터리
        this.addMainStat(40L);          // 하이 위즈덤

        // 3차
        this.addDamage(10L);            // 레프 마스터리
        this.addMainStat(40L);          // 운명 개척
        this.addMagicP(10L);
        this.addMagic(50L);             // 끊임없는 연구
        this.addCriticalDamage(30.0);
        this.addCriticalP(20.0);

        // 4차
        this.addBossDamage(30L);        // 크리스탈의 비밀
        this.addIgnoreDefenseList(25L);
        this.addFinalDamage(1.4);

        // 5차
        this.addMagic(65L);             // 소울 오브 크리스탈

        this.setAbility(new ReuseBossCritical());
        this.setFarm(new ReuseFarm());
        this.getLinkList().add(new HybridLogic());
        this.getLinkList().add(new FlowOfBattle());
        this.setUnion(new IntUnion());
        this.addPerXMainStat(20L);

        this.addObject(this.getAbility());
        this.addObject(this.getFarm());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperCommon(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());
    }

    @Override
    public void Doping() {
        super.Doping();
        addFinalDamage(1.08);           // 오버로드 마나
    }

    public Long getStatDamage() {
        return (long) Math.floor(
                (this.getFinalMainStat() * 4 + getFinalSubstat()) * 0.01
                        * Math.floor(this.getMagic() * (1 + this.getMagicP() * 0.01))
                        * this.getConstant()
                        * (1 + this.getDamage() * 0.01)
                        * this.getFinalDamage()
        );
    }
}
