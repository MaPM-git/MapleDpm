package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.PassiveBossAbnormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.farm.NormalFarm;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.Noblesse;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.IntUnion;

import java.util.stream.Collectors;

public class Kinesis extends Job {

    public Kinesis() {
        // 기본
        super();
        this.setName("키네시스");
        this.setConstant(1.2);          // 무기상수
        this.setMastery(1.92 / 2);      // 숙련도
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
        this.addMainStat(8L);
        this.addSubStat(8L);
        this.addMagic(5L);
        this.addBossDamage(70L);
        this.addMagicP(9L);
        this.addMagicP(21L);
        
        // 0차
        this.addCriticalP(10.0);        // 초감각
        
        // 1차
        this.addMagic(10L);             // 싸이킥 포스
        this.addMagic(10L);             // 내재1

        // 2차
        this.addMagic(10L);             // 싸이킥 포스2
        this.addDamage(20L);            // 순수한 힘
        this.addMagic(10L);             // 내재2
        this.addCriticalP(10.0);        // ESP 마스터리
        this.addMainStat(40L);

        // 3차
        this.addMagic(10L);             // 싸이킥 포스3
        this.addMagicP(10L);            // 정신강화
        this.addCriticalP(20.0);        // 정교
        this.addCriticalDamage(20.0);

        // 4차
        this.addBossDamage(31L);        // 싸이킹 차징
        this.addFinalDamage(1.4);       // 싸이코 브레이크
        this.addMagic(52L);             // ESP 배틀 오더
        this.addDamage(21L);
        this.addFinalDamage(1.21);
        this.addFinalDamage(1.15);      // 각성
        this.addPlusBuffDuration(21L);  // 정신집중-유지
        this.addIgnoreDefenseList(26L);  // 전달
        this.addCriticalDamage(11.0);   // 숙달

        this.setAbility(new PassiveBossAbnormal());
        this.setFarm(new NormalFarm());
        this.getLinkList().add(new PhantomInstinct());
        this.getLinkList().add(new Noblesse());
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
